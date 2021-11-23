package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.application.CRSApplication;
import com.lti.bean.User;
import com.lti.exception.RegistrationFailedException;
import com.lti.exception.UserNotFoundException;
import com.lti.sqlconstant.UserQuery;
import com.lti.util.DBUtils;

/**
 * @author user250
 */

public class UserOperationDao implements UserInterfaceDao{

	@Override
	public boolean doLogin(User login) {
		Connection conn = null;
		   PreparedStatement stmt = null;
		   boolean exist = false;
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   // Step 4 make/open  a connection 
			   
			      System.out.println("Connecting to database...");
			      conn = DBUtils.getConnection();
			   
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      String sql=UserQuery.LOGIN_QUERY;
			    
			      stmt = conn.prepareStatement(sql);
			   
			      // Hard coded data 
			   
			      //Bind values into the parameters.
			      stmt.setString(1, login.getUserName());
			      stmt.setString(2,login.getPassword());
			      stmt.setString(3,login.getRole());
			      
			      ResultSet rs = stmt.executeQuery();
			      while(rs.next()){
			        exist = true;
			      }
			           
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }
			   System.out.println("Goodbye!");
	
		return exist;
	}
	
	public void updatePassword(String username, String password, String newPassword){
		
		   Connection conn = null;
		   PreparedStatement stmt = null;
//		   Boolean checkUsername = false;
		   
		   try{
			   Class.forName("com.mysql.jdbc.Driver");
			   conn = DBUtils.getConnection();
			   
			      String sql = "SELECT login_username,login_password FROM user WHERE (login_username=? and login_password =?)";
			      
			      stmt = conn.prepareStatement(sql);
				  stmt.setString(1, username.toLowerCase());
				  stmt.setString(2, password);
				     
				 ResultSet rs = stmt.executeQuery();
				      
				 if(rs.next()){
//					 checkUsername = true;
					 String sql2 = "UPDATE user set login_password=? WHERE login_username=?";
				     stmt = conn.prepareStatement(sql2);
				     
				      stmt.setString(1, newPassword); 
				      stmt.setString(2,username);
				      
				      try{
				      	stmt.executeUpdate();

					    int rows = stmt.executeUpdate();
					    System.out.println("\n-----------Password updated-----------\n");
				      }catch(Exception ex){
				    	  System.out.println("Exception occured : "+ex.getMessage()+"username and password not matched");
				      }
				   
				}else{
					throw new UserNotFoundException(username);
				}
			      
			   }catch(UserNotFoundException ex){
				   System.out.println("*********Password updataion failed********");
				   System.out.println(ex.getMessage()+" User not found with that credentials \n");
			   }catch(SQLException se){
				      //Handle errors for JDBC
				   System.out.println(se.getMessage());
			   }catch(Exception e){
					   System.out.println(e.getMessage());
		}
}

	@Override	
	public boolean verifyUserNameexists(String username, String password, int roleId) {
		
		if(retrieveRecords(username) == true){
			insert(username, password, roleId);
		}
		return false;
	}
	
	@Override
	public boolean insert(String username, String password, int roleId) {
	
		// Declare the Connection or prepaidstatement variable here 
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   Class.forName("com.mysql.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      System.out.println("\nPlease wait...");
			      conn = DBUtils.getConnection();
			   
			      //STEP 4: Execute a query
			      System.out.println("Inserting data...");
			     String sql="insert into user values(?,?,?,?)";
			 
			      stmt = conn.prepareStatement(sql);
			   
			      if(!username.isEmpty() || !password.isEmpty()){
				      stmt.setString(1, username.toLowerCase());
				      stmt.setString(2, password);
				      stmt.setInt(3, 2);
				      stmt.setInt(4, 0);

				      try{
				    	  
					      	int rows = stmt.executeUpdate();
					      	if(rows > 0){
								System.out.println("Registration Succesfull");
								System.out.println("-------------------Please wait for Admin approval-------------------\n");
//								   stmt.close();
//								   conn.close();
								   
								   CRSApplication.mainMenu();
					      	}else{
					      		throw new RegistrationFailedException(username);
					      	}
					   }catch(RegistrationFailedException ex){
					    	  System.out.println("Exception occured : "+ex.getMessage()+"\n");
					    	  CRSApplication.mainMenu();
					   }
				      
			      }else{
			    	  System.out.println("Error! --> Fields are empty \n");
			    	   CRSApplication.mainMenu();
			      }
			      
			   }catch(SQLException se){
				      //Handle errors for JDBC
				   System.out.println(se.getMessage());
				   }catch(Exception e){
				      //Handle errors for Class.forName
					   System.out.println(e.getMessage());
				   }
		   	return false;
			}//end main
			   
	@Override
	public boolean retrieveRecords(String username) {
		
					Connection conn = null;
				   PreparedStatement stmt = null;
				   
				   try{
					   
					   Class.forName("com.mysql.jdbc.Driver");

					      conn = DBUtils.getConnection();
						
						 String  sql = "SELECT * FROM user where login_username = ?";
					     stmt = conn.prepareStatement(sql);
					     stmt.setString(1, username.toLowerCase());
					     
					    ResultSet rs = stmt.executeQuery();
					      
					    if(rs.next()){
					    	return false;
					    }else{
					    	return true;
					    }
					   }catch(SQLException se){
						      //Handle errors for JDBC
						   System.out.println(se.getMessage());
						   }catch(Exception e){
						      //Handle errors for Class.forName
							   System.out.println(e.getMessage());
						   }
				   return true;
			}//end main
	
	@Override	
	public boolean verifyUserNameexistsForReg(int rollno, String name, String branch, int batch, String status) {
		
		if(retrieveRecords(rollno) == true){
			insertForReg(rollno, name, branch, batch, status);
		}
		return false;
	}
	
	@Override
	public boolean insertForReg(int rollno, String name, String branch, int batch, String status) {
	
		// Declare the Connection or prepaidstatement variable here 
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Register Driver here and create connection 
			   
			   Class.forName("com.mysql.jdbc.Driver");

			   // Step 4 make/open  a connection 
			   
			      System.out.println("\nConnecting to database...");
			      conn = DBUtils.getConnection();
			   
			      //STEP 4: Execute a query
			      System.out.println("Inserting data...");
			     String sql="insert into student values(?,?,?,?,?)";
			 
			      stmt = conn.prepareStatement(sql);
			   
			      if(!name.isEmpty()){
				      stmt.setInt(1, rollno);
				      stmt.setString(2, branch);
				      stmt.setInt(3, batch);
				      stmt.setString(4, name);
				      stmt.setString(5, status);

				      try{
				    	  
					      	int rows = stmt.executeUpdate();
					      	if(rows > 0){
								System.out.println("Student Registration Succesfull");
								System.out.println("-------------------Admin Approval is pending-------------------\\n");
//								   stmt.close();
//								   conn.close();
								   
								   CRSApplication.mainMenu();
					      	}else{
					      		throw new RegistrationFailedException(name);
					      	}
					   }catch(RegistrationFailedException ex){
					    	  System.out.println("Exception occured : "+ex.getMessage()+"\n");
					    	  CRSApplication.mainMenu();
					   }
				      
			      }else{
			    	  System.out.println("Error! --> Fields are empty \n");
			    	   CRSApplication.mainMenu();
			      }
			      
			   }catch(SQLException se){
				      //Handle errors for JDBC
				   System.out.println(se.getMessage());
				   }catch(Exception e){
				      //Handle errors for Class.forName
					   System.out.println(e.getMessage());
				   }
		   	return false;
			}//end main
			   
	@Override
	public boolean retrieveRecords(int username) {
		
					Connection conn = null;
				   PreparedStatement stmt = null;
				   
				   try{
					   
					   Class.forName("com.mysql.jdbc.Driver");

					      conn = DBUtils.getConnection();
						
						 String  sql = "SELECT * FROM student where student_id = ?";
					     stmt = conn.prepareStatement(sql);
					     stmt.setInt(1, username);
					     
					    ResultSet rs = stmt.executeQuery();
					      
					    if(rs.next()){
					    	return false;
					    }else{
					    	return true;
					    }
					   }catch(SQLException se){
						      //Handle errors for JDBC
						   System.out.println(se.getMessage());
						   }catch(Exception e){
						      //Handle errors for Class.forName
							   System.out.println(e.getMessage());
						   }
				   return true;
			}//end main
}
