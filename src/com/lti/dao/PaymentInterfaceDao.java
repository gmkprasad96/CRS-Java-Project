package com.lti.dao;

/**
 * @author user250
 */


public interface PaymentInterfaceDao {

	void StudentCoursePayment(int paymentAmount,String paymentMode, 
			int studentId);
}
