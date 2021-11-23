/**
 * 
 */
package com.lti.exception;

/**
 * @author user250
 *
 */
public class MinimumCourseLimitException extends Exception {
	private int minimumLimit;

	public MinimumCourseLimitException(int num)
	{	
		this.minimumLimit = num;
	}
	
	public String getMessage() 
	{
		return "Please add minimum " + minimumLimit + " courses";
	}

}