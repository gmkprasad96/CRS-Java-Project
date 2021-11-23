package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.lti.util.DBUtils;

/**
 * @author user250
 */

public class NotificationOperationDao implements NotificationInterfaceDao{

	@Override
	public void notifyUserForConfirmation(int studentId, int paymentAmount, String paymentMode) {
		
		 Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   Class.forName("com.mysql.jdbc.Driver");
			   
			      System.out.println("\n========Notification========");
			      conn = DBUtils.getConnection();
			   
			     String sql="insert into notification values(?,?,?,?)";
			     
			      stmt = conn.prepareStatement(sql);
			      NotificationInterfaceDao notification = new NotificationOperationDao();
			   
			      if(!paymentMode.isEmpty() && paymentAmount > 0 && studentId > 0){
			    	  stmt.setInt(1, 0);
			    	  stmt.setInt(2, studentId);
				      stmt.setString(3,paymentMode.toLowerCase());
			    	  stmt.setDouble(4, paymentAmount);
				      
				     
				       	int rows = stmt.executeUpdate();
					      	if(rows > 0){
								System.out.println("\nPayment Succesfull");
								System.out.println("Please collect your bill receipt....\n");
								System.out.println("Student id : "+studentId);
								System.out.println("Total Amount paid : "+paymentAmount);
								System.out.println("Mode of payment : "+paymentMode);
								System.out.println("\n======================================\n");
								  //add menu here
					      	}else{
					      		System.out.println("Notification Failed");
					   }
			      }else{
			    	  System.out.println("Error! --> Fields are empty \n");
			    	  //add menu here
			      }
			      
			   }catch(SQLException se){
				      //Handle errors for JDBC
				   System.out.println(se.getMessage());
				   }catch(Exception e){
				      //Handle errors for Class.forName
					   System.out.println(e.getMessage());
				   }
	}
}
