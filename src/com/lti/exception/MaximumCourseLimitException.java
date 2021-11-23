/**
 * 
 */
package com.lti.exception;

/**
 * @author user250
 *
 */
public class MaximumCourseLimitException extends Exception {
	private int maxLimit;

	public MaximumCourseLimitException(int num)
	{	
		this.maxLimit = num;
	}
	
	public String getMessage() 
	{
		return "You have already registered for " + maxLimit + " courses";
	}

}
