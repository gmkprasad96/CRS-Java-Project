/**
 * 
 */
package com.lti.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.GradeCard;
import com.lti.bean.Student;
import com.lti.dao.ProfessorInterfaceDao;
import com.lti.dao.ProfessorOperationDao;

/**
 * @author user252
 *
 */
public class ProfessorOperations implements ProfessorInterface{
	
	ProfessorInterfaceDao dao = new ProfessorOperationDao();
	public void viewEnrolledStudents(){
		
		List<Student> students = dao.getEnrolledStudent();
		System.out.println("List of enrolled students");
		System.out.println("---------------------------------------------------------------------------------------------");  
		System.out.printf("%5s %10s %10s %8s %20s", "Roll No", "NAME", "BRANCH", "BATCH", "STATUS");  
		System.out.println();  
		System.out.println("---------------------------------------------------------------------------------------------");
 
		for(Student s : students){
			System.out.format("%7s %14s %7s %10s %25s",s.getStudentId(), s.getStudentName(),s.getBranch(), s.getBatch(), s.getApprovedStatus());  
			System.out.println();  
		}
		System.out.println("----------------------------------------------------------------------------------------------");  
	}
	
	public void viewCourses(){
		
	     List<Course> courses = dao.getCourse();
		
	     System.out.println("Professor Courses");
	     System.out.println("---------------------------------------------------------------------------------------------");  
			System.out.printf("%5s %10s %10s %8s %20s", "COURSE CODE", "NAME", "INSTRUCTOR", "OFFERED", "SEMESTER");  
			System.out.println();  
			System.out.println("---------------------------------------------------------------------------------------------");
	 
			 for(Course c : courses){
				System.out.format("%7s %14s %7s %10s %25s",c.getCourseCode(),c.getName(),c.getInstructor(), c.getOfferedStatus(), c.getSemester());  
				System.out.println();  
			}
			System.out.println("----------------------------------------------------------------------------------------------"); 
	}
	
	public void addStudentGradeInReport(int studentId, int reportId, String grade){
	    System.out.println("Student Report updated");	
	}
}
