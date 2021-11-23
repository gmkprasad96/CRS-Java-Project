package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;

/**
 * @author user250
 */

public interface StudentInterfaceDao {

	
	public void registerForCourse();
	public void addcourses();
	public void dropCourses();
	public void payment();
	public void viewReportCard();
}
