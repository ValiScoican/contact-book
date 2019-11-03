package com.licenta.ContactBook.controller;

import com.licenta.ContactBook.model.User;
import com.licenta.ContactBook.model.UserDto;
import com.licenta.ContactBook.service.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users/get")
	public User getUserByUsername(@RequestParam("username") String username) {
		return userService.getUserByUsername(username);
	}

	@GetMapping("/users/get/email")
	public User getUserByEmail(@RequestParam("email") String email) {
		return userService.getUserByEmail(email);
	}

	@PostMapping("/users/add")
	public void addUser(@RequestBody User newUser) {
		userService.addUser(newUser);
	}

}
