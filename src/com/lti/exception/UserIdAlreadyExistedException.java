/**
 * 
 */
package com.lti.exception;

/**
 * @author user250
 *
 */
public class UserIdAlreadyExistedException extends Exception {
	
	private String userId;
	
	
	public UserIdAlreadyExistedException(String userId) {
		this.userId = userId;
	}
	
	public String getMessage() {
		return "userId: " + userId + " is already in use.";
	}
}
