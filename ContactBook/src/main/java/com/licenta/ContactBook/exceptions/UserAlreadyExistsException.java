package com.licenta.ContactBook.exceptions;

import javax.naming.AuthenticationException;

public class UserAlreadyExistsException extends AuthenticationException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3593294643657188466L;

	public UserAlreadyExistsException(String message) {
        super(message);
    }
}
