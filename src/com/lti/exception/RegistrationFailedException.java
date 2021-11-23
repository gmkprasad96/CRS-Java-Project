/**
 * 
 */
package com.lti.exception;

/**
 * @author user250
 *
 */
public class RegistrationFailedException extends Exception {
	
	private String userName;

	 public RegistrationFailedException(String userName)
	 {
		 this.userName = userName;
	 }
	 
	 public String getMessage()
	 {
		 return "Registration Failed : "+userName;
	 }
	
	
}
