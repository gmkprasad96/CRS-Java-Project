/**
 * 
 */
package com.lti.exception;

/**
 * @author user250
 *
 */
public class GradeNotFoundException extends Exception{
	private int studentId;
	 
	 public GradeNotFoundException(int studentId)
	 {
		 this.studentId=studentId;
	 }
	 
	 public String getMessage()
	 {
		 return "Please update/add garde to : " + studentId;
	 }
}



 