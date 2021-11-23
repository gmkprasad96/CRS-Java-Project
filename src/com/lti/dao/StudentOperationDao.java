package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.Student;
//import com.lti.constant.StudentQuery;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.CourseRegisteredAlreadyException;
import com.lti.exception.MaximumCourseLimitException;
import com.lti.exception.MinimumCourseLimitException;
import com.lti.util.DBUtils;

/**
 * @author user250
 */

public class StudentOperationDao implements StudentInterfaceDao {

	Scanner sc=new Scanner(System.in);
	
	public void registerForCourse(){
		Connection conn = null;
		   PreparedStatement stmt = null;
		   Statement st=null;
		   
               try{
			   
			   Class.forName("com.mysql.jdbc.Driver");
			   
			      System.out.println("\nPlease wait...");
			      conn = DBUtils.getConnection();
			      System.out.println("\nCurrent Available Courses: ");
			      System.out.println("=======================================================");
			      //String sql="SELECT course_id,course_code,course_name,course_isoffered,course_instructor,course_semester FROM course";
			      String sql="SELECT * FROM course";
                           //String sql=StudentQuery.VIEW_COURSES;
			      stmt = conn.prepareStatement(sql);
			      ResultSet rs = stmt.executeQuery(sql);
			      String courses="";
			      String cc=null;
//			      while(rs.next()){
//			    	  cc=rs.getString(2)+ " ";
//			    	  
//			      }
			      while(rs.next()){
			    	  courses=rs.getInt(1)+ "        "+ rs.getString(2)+ "        "+rs.getString(3)+ "        "+rs.getString(4)+ "        "+
			                              rs.getString(5)+ "        "+ rs.getInt(6);
			    	  System.out.println(courses);
			      }
			      System.out.println("=======================================================");
			      String coursecodeArray[]=new String[]{"c1","c2","c3","c4","c5"};
			    	  System.out.println("\n Please enter the studentid: ");
			    	  int sid=sc.nextInt();
			    	  System.out.println("\n Please enter the no.of courses you are going to select");
			    	  int noofcourses=sc.nextInt();
			    	  if(noofcourses<=0 )
			    		  throw new MinimumCourseLimitException(noofcourses);
			    	  if(noofcourses>=4 )
			    		  throw new MaximumCourseLimitException(noofcourses);
			    	  System.out.println("\nPlease enter the coursecodes that you need to select: ");
			    	  String coursecode[]=new String[noofcourses];
			    	  for(int i=0; i<coursecode.length;i++)
			    		  coursecode[i] =sc.next();
			    	  for(int i=0; i<coursecode.length;i++){
			    		  if(!((coursecode[i].equals("c1")) || (coursecode[i].equals("c2")) || (coursecode[i].equals("c3"))
			    				  || (coursecode[i].equals("c4")) || (coursecode[i].equals("c5"))))
			    	        throw new CourseNotFoundException(coursecode[i]);
			    	  }
			    	  for(int i=0; i<coursecode.length;i++){
			    		  for(int j=i+1;j<coursecode.length;j++){
			    			  if(coursecode[i].equals(coursecode[j]) )
			    				  throw new CourseRegisteredAlreadyException(coursecode[i]);
			    		  }
			    	  }
			      String sql2="insert into studentcoursemapping values (?,?)";
			     // String sql2=StudentQuery.INSERT_COURSES;
			      stmt = conn.prepareStatement(sql2);
			         
			      for(int i=0; i<coursecode.length;i++){
			    	  
			    	  stmt.setInt(1, sid);
			          stmt.setString(2, coursecode[i]);
			          stmt.executeUpdate();
			      }
//			      stmt.close();
//			      conn.close();
			      System.out.println("courses were registerd successfully");
               }
               catch(MinimumCourseLimitException e){
            	   System.out.println("Exception -->Please select more than 0 courses");
               }
               catch(MaximumCourseLimitException e){
            	   System.out.println("Exception -->Course Limit has exceeded");
            	   System.out.println("Please choose less than 4 courses");
               }
               catch (CourseNotFoundException e) {
				System.out.println(e.getCourseCodeMessage());
				System.out.println("Please enter the proper coursecode");
			}catch (CourseRegisteredAlreadyException e){
				System.out.println("Exception--->"+e.getMessage());
			}
			      catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
               }
               
	}
	
	public void addcourses(){
		Connection conn = null;
		   PreparedStatement stmt = null;
		System.out.println("please enter the studentid");
		int sid=sc.nextInt();
		
		 try{
			   
			   Class.forName("com.mysql.jdbc.Driver");
			   
			      System.out.println("\nPlease wait...");
			      conn = DBUtils.getConnection();
			      System.out.println("\n Current coursecodes that you have registered with your student id: ");
			      String sql="SELECT * FROM studentcoursemapping where student_id="+(sid);
                  //String sql=StudentQuery.VIEW_COURSES+(sid);
			      String coursecodeArray[]=new String[]{"c1","c2","c3"};
	      stmt = conn.prepareStatement(sql);
	      ResultSet rs = stmt.executeQuery(sql);
	      String courses="";
	      String cc="";
      while(rs.next()){
	    	  cc=rs.getString(2);
	    	  System.out.println(cc);
     }
			      System.out.println("\n Please enter the no.of courses you are going to add");
		    	  int noofcourses=sc.nextInt();
		    	  if(noofcourses<=0 )
		    		  throw new MinimumCourseLimitException(noofcourses);
		    	  if(noofcourses>=4 )
		    		  throw new MaximumCourseLimitException(noofcourses);
		    	  System.out.println("\nPlease enter the coursecodes that you need to select: ");
		    	  String coursecode[]=new String[noofcourses];
		    	  for(int i=0; i<coursecode.length;i++)
		    		  coursecode[i] =sc.next();
		    	  
//		    	  for(int i=0; i<coursecode.length;i++){
//		    		  String s=coursecode[i].toString();
//		    	  String sql3="SELECT * FROM studentcoursemapping WHERE course_code="+(s);
//		    	  stmt = conn.prepareStatement(sql3);
//			      ResultSet rs1 = stmt.executeQuery(sql3);
//			      if(rs1!=null)
//			    	  throw new CourseRegisteredAlreadyException(coursecode[i]);
//		    	  }
		    	  for(int i=0; i<coursecode.length;i++){
		    		  if(!((coursecode[i].equals("c1")) || (coursecode[i].equals("c2")) || (coursecode[i].equals("c3"))))
		    	        throw new CourseNotFoundException(coursecode[i]);
		    	  }
		    	  for(int i=0; i<coursecode.length;i++){
		    		  for(int j=i+1;j<coursecode.length;j++){
		    			  if(coursecode[i].equals(coursecode[j]) )
		    				  throw new CourseRegisteredAlreadyException(coursecode[i]);
		    		  }
		    	  }
		      String sql2="insert into studentcoursemapping values (?,?)";
		      stmt = conn.prepareStatement(sql2);
		      
		      
		      for(int i=0;i<coursecode.length;i++){
		    	  stmt.setInt(1,sid);
		          stmt.setString(2, coursecode[i]);
		          stmt.executeUpdate();
		      }
		      
		     
		   //   stmt.close();
		    // conn.close();
		      System.out.println("courses were added successfully"); 
		 }catch(MinimumCourseLimitException e){
      	   System.out.println("Exception -->Please select more than 0 courses");
         }
         catch(MaximumCourseLimitException e){
      	   System.out.println("Exception -->Course Limit has exceeded");
      	 System.out.println("Please choose less than 4 courses");
         }
		 catch (CourseNotFoundException e) {
				System.out.println(e.getCourseCodeMessage());
				System.out.println("Please enter the proper coursecode");
			}catch (CourseRegisteredAlreadyException e){
				System.out.println("Exception--->"+e.getMessage());
			}
		
		 catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		     
      }
		 
		 
	}
	public void dropCourses(){
		Connection conn = null;
		   PreparedStatement stmt = null;
		System.out.println("please enter the studentid");
		int sid=sc.nextInt();
		
		 try{
			   
			   Class.forName("com.mysql.jdbc.Driver");
			   
			      System.out.println("\nPlease wait...");
			      conn = DBUtils.getConnection();
			      System.out.println("\n Current coursecodes that you have registered with your student id: ");
			      String sql="SELECT * FROM studentcoursemapping where student_id="+(sid);
                  //String sql=StudentQuery.VIEW_COURSES;
			      
	      stmt = conn.prepareStatement(sql);
	      ResultSet rs = stmt.executeQuery(sql);
	      String courses="";
	      String cc="";
      while(rs.next()){
	    	  cc=rs.getString(2)+ " ";
	    	  System.out.println(cc);
     }
      
			      System.out.println("\n Please enter the no.of courses you are going to drop");
			      int noofcourses=sc.nextInt();
			      if(noofcourses<=0 )
		    		  throw new MinimumCourseLimitException(noofcourses);
		    	  if(noofcourses>=4 )
		    		  throw new MaximumCourseLimitException(noofcourses);
		    	  System.out.println("\nPlease enter the coursecodes that you need to drop: ");
		    	  String coursecode[]=new String[noofcourses];
		    	  for(int i=0; i<coursecode.length;i++)
		    		  coursecode[i] =sc.next();
		    	  for(int i=0; i<coursecode.length;i++){
		    		  if(!((coursecode[i].equals("c1")) || (coursecode[i].equals("c2")) || (coursecode[i].equals("c3"))))
		    	        throw new CourseNotFoundException(coursecode[i]);
		    	  }
		    	  for(int i=0; i<coursecode.length;i++){
		    		  for(int j=i+1;j<coursecode.length;j++){
		    			  if(coursecode[i].equals(coursecode[j]) )
		    				  throw new CourseRegisteredAlreadyException(coursecode[i]);
		    		  }
		    	  }
		    	  String sql2="delete from studentcoursemapping where student_id=? and course_code=?";
		    	  //String sql2=StudentQuery.DROP_COURSE;
		    	  stmt = conn.prepareStatement(sql2);
		    	  for(int i=0; i<coursecode.length;i++){
		    	  stmt.setInt(1, sid);
		    	  stmt.setString(2, coursecode[i]);
		    	  stmt.executeUpdate();
		    	  }
		    	 
		    	  System.out.println("course is deleted successfully");
		 }
		 catch(MinimumCourseLimitException e){
      	   System.out.println("Exception -->Please select more than 0 courses");
         }
         catch(MaximumCourseLimitException e){
      	   System.out.println("Exception -->Course Limit has exceeded");
      	 System.out.println("Please choose less than 4 courses");
         }catch (CourseNotFoundException e) {
				System.out.println(e.getCourseCodeMessage());
				System.out.println("Please enter the proper coursecode");
			}catch (CourseRegisteredAlreadyException e){
				System.out.println("Exception--->"+e.getMessage());
			}
		 catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		 }
	 }
	
	public static void main(String[] args){	
	StudentOperationDao sd=new StudentOperationDao();
	
   sd.registerForCourse();
     // sd.addcourses();
  	//sd.dropCourses();
  	}
	public void viewReportCard(){
		Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
		System.out.println("please enter student_id:" );
		int sid=sc.nextInt();
		System.out.println("Student id :"+sid);
		System.out.println("Student name :" +"abdul");
		System.out.println("Courses :: ");
		String sql="SELECT * FROM studentcoursemapping where student_id="+(sid);
        //String sql=StudentQuery.VIEW_COURSES;
		 Class.forName("com.mysql.jdbc.Driver");
		   
	      System.out.println("\nPlease wait...");
	      conn = DBUtils.getConnection();
stmt = conn.prepareStatement(sql);
ResultSet rs = stmt.executeQuery(sql);

String cc="";
while(rs.next()){
	  cc=rs.getString(2);
	  System.out.println(cc);
}

		System.out.println("Overall Grade : "+"A");
	}catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	 }
	}
	
	public void payment(){
		//payment operation needs to be included
	}
}
