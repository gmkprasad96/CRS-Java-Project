package com.lti.dao;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.GradeCard;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.exception.CourseNotFoundException;

/**
 * @author user250
 */

public interface AdminInterfaceDao {

	boolean isCourseExists(String courseCode);
	void addCourse(Course c);
	void removeCourse(String courseCode) throws CourseNotFoundException;
	boolean isProfExists(int professorId);
	void addProfessor(Professor newProf);
	GradeCard getGradeCard(int studentId, int semester);
	int approveStudents(Student std);
}
