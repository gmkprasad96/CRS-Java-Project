package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.sqlconstant.ProfessorQuery;
import com.lti.util.DBUtils;

/**
 * @author user250
 */

public class ProfessorOperationDao implements ProfessorInterfaceDao{

	@Override
	public List<Student> getEnrolledStudent() {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement stmt = null;
		 List<Student> students  = new ArrayList<>();
		   try{
			   // Step 4 make/open  a connection 
			   
			      System.out.println("Connecting to database...");
			      conn = DBUtils.getConnection();
			   	  System.out.println("Creating statement...");
			      String sql=ProfessorQuery.VIEW_STUDENT_QUERY;
			     
			      stmt = conn.prepareStatement(sql);
			      
			      ResultSet rs = stmt.executeQuery();
			      while(rs.next()){
			         Student s = new Student();
			    	 s.setStudentId(rs.getInt(1));
			    	 s.setBranch(rs.getString(2));
			    	 s.setBatch(rs.getInt(3));
			    	 s.setStudentName(rs.getString(4));
			    	 s.setApprovedStatus(rs.getString(5));
			    	 students.add(s);
			      }
			      //STEP 6: Clean-up environment
			     // rs.close();
			     
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }
		return students;
	}

	@Override
	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		Connection conn = null;
		 PreparedStatement stmt = null;
		 List<Course> courses  = new ArrayList<>();
		   try{
			   // Step 4 make/open  a connection 
			   
			      System.out.println("Connecting to database...");
			      conn = DBUtils.getConnection();
			   	  System.out.println("Creating statement...");
			      String sql=ProfessorQuery.VIEW_COURSES_QUERY;
			     
			      stmt = conn.prepareStatement(sql);
			      
			      ResultSet rs = stmt.executeQuery();
			      while(rs.next()){
			         Course s = new Course();
			    	 s.setCourseCode(rs.getString(1));
			    	 s.setName(rs.getString(2));
			    	 s.setOfferedStatus(rs.getString(3));
			    	 s.setInstructor(rs.getString(4));
			    	 s.setSemester(rs.getInt(5));
			    	 courses.add(s);
			      }
			      //STEP 6: Clean-up environment
			     // rs.close();
			     
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }
		return courses;
	}

}
