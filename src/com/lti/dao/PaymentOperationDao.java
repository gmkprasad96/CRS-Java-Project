package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.application.CRSApplication;
import com.lti.exception.PaymentFailedException;
import com.lti.util.DBUtils;

/**
 * @author user250
 */

public class PaymentOperationDao implements PaymentInterfaceDao{

	@Override
	public void StudentCoursePayment( int studentId, String paymentMode, int paymentAmount) {
		
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   Class.forName("com.mysql.jdbc.Driver");
			   
			      System.out.println("\nPlease wait...");
			      conn = DBUtils.getConnection();
			   
			     String sql="insert into payment values(?,?,?,?)";
			     
			      stmt = conn.prepareStatement(sql);
			      NotificationInterfaceDao notification = new NotificationOperationDao();
			   
			      if(!paymentMode.isEmpty() && paymentAmount > 0 && studentId > 0){
				      stmt.setInt(1, 0);
				      stmt.setString(2,paymentMode.toLowerCase());
				      stmt.setInt(3, paymentAmount);
				      stmt.setInt(4, studentId);

				      try{
				    	  
					      	int rows = stmt.executeUpdate();
					      	if(rows > 0){
								notification.notifyUserForConfirmation(studentId, paymentAmount, paymentMode);
								  //add menu here
					      	}else{
					      		throw new PaymentFailedException(paymentAmount, studentId);
					      	}
					   }catch(PaymentFailedException ex){
					    	  System.out.println("Exception occured : "+ex.getMessage()+"\n");
					    	  CRSApplication.mainMenu();
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
