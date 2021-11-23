package com.lti.sqlconstant;

/**
 * @author user250
 */

public class UserQuery {
	
	public static final String LOGIN_QUERY = "select u.login_username from user u inner join role r " +
			"on u.login_role_id = r.role_id where " +
			"u.login_username=? and u.login_password=? and r.role_name=?";
}
