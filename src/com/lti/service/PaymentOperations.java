/**
 * 
 */
package com.lti.service;

import com.lti.bean.Payment;
import com.lti.bean.Course;
import com.lti.bean.Student;

/**
 * @author user252
 *
 */
public class PaymentOperations extends StudentOperations implements PaymentInterface{

	Payment b = new Payment();
	//Student s = new Student();
	//Course c = new Course();
	
	/* (non-Javadoc)
	 * @see com.lti.service.PaymentInterface#onlineMode()
	 */
	@Override
	public void onlineMode() {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see com.lti.service.PaymentInterface#offlineMode()
	 */
	@Override
	public void offlineMode() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
