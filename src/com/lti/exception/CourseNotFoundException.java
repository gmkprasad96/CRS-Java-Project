/**
 * 
 */
package com.lti.exception;

/**
 * @author user250
 *
 */
public class CourseNotFoundException extends Exception {
	
	private int courseId;
	private String courseCode;
	
	public CourseNotFoundException(String courseCode)
	{	 
		this.courseCode = courseCode;
	}
	
	public CourseNotFoundException(int courseId)
	{	 
		this.courseId = courseId;
	}
	
	public String getCourseCodeMessage() 
	{
		return "Course with : " + courseCode + " not found";
	}
	
	public String getCourseIdMessage() 
	{
		return "Course with : " + courseId + " not found";
	}
}
