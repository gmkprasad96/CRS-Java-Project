/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.GradeCard;
import com.lti.bean.Student;

/**
 * @author user252
 *
 */
public interface ProfessorInterface {

    public void viewEnrolledStudents();
	
	public void viewCourses();
		
	public void addStudentGradeInReport(int s, int r, String g);
}
