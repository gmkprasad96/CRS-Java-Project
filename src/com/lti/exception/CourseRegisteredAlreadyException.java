package com.lti.exception;

/**
 * @author user250
 */

public class CourseRegisteredAlreadyException extends Exception{
	
	private String courseCode;
	
	public CourseRegisteredAlreadyException(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getMessage() {
		return "You have already registered for " + courseCode;
	}
}
