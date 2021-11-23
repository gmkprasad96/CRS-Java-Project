package com.lti.dao;

/**
 * @author user250
 */

public interface NotificationInterfaceDao {
	void notifyUserForConfirmation(int studentId, int paymentAmount, String paymentMode);
}
