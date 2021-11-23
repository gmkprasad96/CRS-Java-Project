/**
 * 
 */
package com.lti.service;

import java.util.HashMap;
import java.util.Map;

import com.lti.bean.User;
import com.lti.dao.UserInterfaceDao;
import com.lti.dao.UserOperationDao;
import com.lti.exception.CourseFoundinCatalagException;
import com.lti.exception.UserNotFoundException;

/**
 * @author user252
 *
 */
public class UserOperations implements UserInterface{
	
	UserInterfaceDao dao = new UserOperationDao();
			
	public boolean doLogin(User login) throws UserNotFoundException{
		
		boolean userExist = dao.doLogin(login);
		return userExist;
	}

	/* (non-Javadoc)
	 * @see com.lti.service.UserInterface#updatePassword()
	 */
	
	@Override
	public void updatePassword(String username, String password,
			String newPassword) {
		// TODO Auto-generated method stub
		dao.updatePassword(username, password, newPassword);
	}
	
}
