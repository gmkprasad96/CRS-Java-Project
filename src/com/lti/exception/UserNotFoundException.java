/**
 * 
 */
package com.lti.exception;

/**
 * @author user250
 *
 */
public class UserNotFoundException extends Exception {
		
	private String userName;
	
	public UserNotFoundException(String userName) {
		this.userName = userName;
	}
	
	public String getMessage() {
		return "UserName: " + userName;
	}
	
}
