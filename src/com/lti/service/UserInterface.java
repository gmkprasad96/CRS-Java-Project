/**
 * 
 */
package com.lti.service;

import com.lti.bean.User;
import com.lti.exception.UserNotFoundException;

/**
 * @author user252
 *
 */
public interface UserInterface{
	
    public boolean doLogin(User login) throws UserNotFoundException;
	
    public void updatePassword(String username, String password, String newPassword);
}
