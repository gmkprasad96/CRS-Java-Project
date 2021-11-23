package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;

/**
 * @author user250
 */

public interface ProfessorInterfaceDao {

	public List<Student> getEnrolledStudent();
	
	public List<Course> getCourse();
}
