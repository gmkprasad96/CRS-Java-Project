package com.lti.dao;

import com.lti.bean.User;
/**
 * @author user250
 */


public interface UserInterfaceDao {

	public boolean doLogin(User login);
	
	public void updatePassword(String username, String password, String newPassword);

	boolean verifyUserNameexists(String username, String password, int roleId);

	boolean insert(String username, String password, int roleId);

	boolean retrieveRecords(String username);
	
	boolean verifyUserNameexistsForReg(int rollno, String name, String branch, int batch, String status);

	boolean insertForReg(int rollno, String name, String branch, int batch, String status);
	
	boolean retrieveRecords(int rollno);

}
