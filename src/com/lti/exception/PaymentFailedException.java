package com.lti.exception;

/**
 * @author user250
 */

public class PaymentFailedException extends Exception  {
	
	private int amount;
	private int studentId;
	
	 public PaymentFailedException(int amount, int studentId)
	 {
		 this.amount = amount;
		 this.studentId = studentId;
	 }
	 
	 public String getMessage()
	 {
		 return "Payment Failed : \n"
				 +"Student id :"+studentId+"\n"
				 +"Amount : "+amount;
	 }
	
	
	 
}
