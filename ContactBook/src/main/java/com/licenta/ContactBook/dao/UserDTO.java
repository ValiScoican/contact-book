package com.licenta.ContactBook.dao;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDTO {

	@NotNull
	@NotEmpty
	private String username;

	@NotNull
	@NotEmpty
	private String password;
	
	@NotNull
	@NotEmpty
	private String matchingPassword;

	@NotNull
	@NotEmpty
	private String email;
	
}
