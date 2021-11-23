/**
 * 
 */
package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;

/**
 * @author user252
 *
 */
public interface StudentInterface {

    public void registerForCourse() throws Exception;
	
    public void addCourses(List<Course> name) throws Exception;

    public void dropCourses(Student s);
	
	public void viewGrades();
	
	public void payFees(Student s);
}
