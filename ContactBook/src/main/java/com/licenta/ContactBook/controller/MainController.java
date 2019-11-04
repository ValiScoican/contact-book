package com.licenta.ContactBook.controller;

import com.licenta.ContactBook.exceptions.UserAlreadyExistsException;
import com.licenta.ContactBook.model.User;
import com.licenta.ContactBook.model.UserDto;
import com.licenta.ContactBook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

/**
 * Main site controller. Contains user registration methods.
 */
@Controller
public class MainController {

	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * User service used to add new users.
	 */
	@Autowired
	private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

	/**
	 * Serve registration page.
	 *
	 * @param request -
	 * @param model - Served model.
	 * @return return reg. page.
	 */
    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }

	/**
	 * Post method for new user registration.
	 *
	 * @param accountDto - New user account
	 * @return redirect to login page
	 */
	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String registerUserAccount (@ModelAttribute("user") @Valid UserDto accountDto) throws UserAlreadyExistsException {
		String username = accountDto.getUsername();
		String email = accountDto.getEmail();
		User registered = new User(
				username,
				new BCryptPasswordEncoder().encode(accountDto.getPassword()),
				email,
				"ROLE_USER",
				"");

       	User usr = userService.getUserByUsername(username);
       	if (usr != null && (usr.getUsername().equals(username) || usr.getEmail().equals(email))) {
			throw new UserAlreadyExistsException("User with this username or e-mail already exists!");
		} else {
			userService.addUser(registered);

//			SimpleMailMessage msg = new SimpleMailMessage();
//			msg.setTo(email);
//
//			msg.setSubject("Succesful reg.");
//			msg.setText("Hello World \n Spring Boot Email");
//
//			javaMailSender.send(msg);

			return "login";
		}
    }
}
