package com.lti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lti.application.CRSApplication;
import com.lti.bean.Course;
import com.lti.bean.GradeCard;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.PaymentFailedException;
import com.lti.util.DBUtils;

/**
 * @author user250
 */

public class AdminOperationDao implements AdminInterfaceDao{

	@Override
	public boolean isCourseExists(String courseCode) {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement stmt = null;
		 boolean exist = false;
		   try{
			   // Step 4 make/open  a connection 
			   
			      System.out.println("Connecting to database...");
			      conn = DBUtils.getConnection();
			   	  System.out.println("Creating statement...");
			      String sql="select * from course where course_code=?";
			     
			      stmt = conn.prepareStatement(sql);
			      stmt.setString(1,courseCode);
			      
			      ResultSet rs = stmt.executeQuery();
			      while(rs.next()){
			        exist = true;
			      }
			      //STEP 6: Clean-up environment
			     // rs.close();
			     
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      System.out.println(se.getMessage());
			   }catch(Exception e){
			      //Handle errors for Class.forName
				   System.out.println(e.getMessage());
			   }
		return exist;
			}//end main

	@Override
	public void addCourse(Course c) {

		   Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   // Step 4 make/open  a connection 
			   
			      System.out.println("Please wait...");
			      conn = DBUtils.getConnection();
			      String sql="insert into course values(?,?,?,?,?,?)";
			    
			      stmt = conn.prepareStatement(sql);
			   
			      // Hard coded data 
			      
			      String isOffered = c.isOffered() ? "Y" : "N";
			      //Bind values into the parameters.
			      stmt.setInt(1, 0);
			      stmt.setString(2,c.getCourseCode());
			      stmt.setString(3,c.getName());
			      stmt.setString(4, isOffered);
			      stmt.setString(5, c.getInstructor());
			      stmt.setInt(6, c.getSemester());
//			      stmt.executeUpdate();
			           
			         	int rows = stmt.executeUpdate();
				      	if(rows > 0){
				      		System.out.println("Course Added "+"\n");
							  //add menu here
				      	}else{
				      		System.out.println("Failed to insert new Course "+"\n");
				      	}
				  
			      //stmt.close();
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }	
		   }

	@Override
	public void removeCourse(String courseCd ) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			   // Step 3 Regiater Driver here and create connection 
			   // Step 4 make/open  a connection 
			   
			   System.out.println("Please wait...");
			   conn = DBUtils.getConnection();
			      String sql="delete from course where course_code=?";
			    
			      stmt = conn.prepareStatement(sql);
			      stmt.setString(1, courseCd);
			      
			      int count = stmt.executeUpdate();
			      if(count == 0) {
			    	  throw new CourseNotFoundException(courseCd);
			      }else {
			    	  System.out.println("Deleted : "+courseCd);
			      }
		   }
		   catch(CourseNotFoundException e) {
			
			  System.out.println(e.getCourseIdMessage());
		   }catch(Exception ex) {
			   System.out.println(ex.getMessage());
		   }

	}

	@Override
	public boolean isProfExists(int professorId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		 PreparedStatement stmt = null;
		 boolean exist = false;
		   try{
			   // Step 4 make/open  a connection 
			   
			   System.out.println("Please wait...");
			      conn = DBUtils.getConnection();
			      String sql="select * from professor where professor_id=?";
			     
			      stmt = conn.prepareStatement(sql);
			      stmt.setInt(1,professorId);
			      
			      ResultSet rs = stmt.executeQuery();
			      while(rs.next()){
			        exist = true;
			      }
			      //STEP 6: Clean-up environment
			     // rs.close();
			     
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }
		   		
		return exist;
	}

	@Override
	public void addProfessor(Professor newProf) {
		// TODO Auto-generated method stub
		  Connection conn = null;
		  PreparedStatement stmt = null;
		  try {
			  System.out.println("Please wait...");
		      conn = DBUtils.getConnection();
		   
		      //STEP 4: Execute a query
		      System.out.println("Data inserting...");
		      String sql="insert into professor values(?,?,?,?)";
		    
		      stmt = conn.prepareStatement(sql);
		   
		      // Hard coded data 
		      
		      //Bind values into the parameters.
		      stmt.setInt(1, 0);
		      stmt.setString(2,newProf.getDepartment());
		      stmt.setString(3,newProf.getDesignation());
			  stmt.setDate(4, (Date) newProf.getDoj());
//		      stmt.executeUpdate();
			  int rows = stmt.executeUpdate();
		      	if(rows > 0){
		      		System.out.println("Professor Added "+"\n");
					  //add menu here
		      	}else{
		      		System.out.println("Failed to insert Professor "+"\n");
		      	}
		           
//		      stmt.close();
//		      conn.close();
		   	}catch(Exception se){
			      //Handle errors for JDBC
				   		System.out.println(se.getMessage());
			}
	}
	
	
	@Override
	public GradeCard getGradeCard(int studentId, int semester) {
		 Connection conn = null;
		 ResultSet rs=null;
		 PreparedStatement stmt = null;
		 GradeCard gc = new GradeCard();
		   try{
			   // Step 4 make/open  a connection 
			   
			   System.out.println("Please wait...");
			      conn = DBUtils.getConnection();
			      String sql="select * from gradecard where gradecard_student_id=? and gradecard_semester=?";
			     
			      stmt = conn.prepareStatement(sql);
			      stmt.setInt(1,studentId);
			      stmt.setInt(2,semester);
			      
			      rs = stmt.executeQuery();
			      while(rs.next()) {
			    	  gc.setCardId(rs.getInt(1));
			    	  gc.setSemester(rs.getInt(2));
			    	  gc.setCpi(rs.getDouble(3));
			    	  gc.setStudentId(rs.getInt(4));
			    	  
			      }
			      //STEP 6: Clean-up environment
			     // rs.close();
			     
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }
		   return gc;
	}

	@Override
	public int approveStudents(Student studentForRegistration) {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs=null;
		PreparedStatement stmt = null;
		int count =0;
		try { 
			System.out.println("Connecting to database...");
		    conn = DBUtils.getConnection();
		    String sql="update student set student_approval_status=? where student_id=?";
		    stmt = conn.prepareStatement(sql);
		    stmt.setString(1, "Y");
		    stmt.setInt(2, studentForRegistration.getStudentId());
		    
//		    count = stmt.executeUpdate();
		    count = stmt.executeUpdate();
	      	if(count > 0){
	      		System.out.println("Student approval updated "+"\n");
				  //add menu here
	      	}else{
	      		System.out.println("Failed to update Student approval "+"\n");
	      	}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return count;      
	}
	}
