/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;

/**
 * @author user252
 *
 */
public interface AdminInterface {

	public void addCoursesInCatalogue(Course newCourse);
//	public void removeCoursesFromCatalogue(String course);
	public void removeCoursesFromCatalogue(Course course);
	public void addProfessor(Professor newProf);
	public void generateReportCard(int studentId, int semester);
	public void approveStudentRegistration(List<Student> studentsForRegistration);
}
