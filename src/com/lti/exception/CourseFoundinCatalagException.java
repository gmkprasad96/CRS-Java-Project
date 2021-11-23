/**
 * 
 */
package com.lti.exception;

/**
 * @author user250
 *
 */
public class CourseFoundinCatalagException extends Exception{
	private String courseCode;
	
	public CourseFoundinCatalagException(String courseCode) {
		this.courseCode = courseCode;
	}
	
	@Override
	public String getMessage() {
		return "Course with courseCode: " + courseCode + " already present in catalog";
	}
}
