package com.lti.sqlconstant;

/**
 * @author user250
 */

public class ProfessorQuery {

	public static final String VIEW_STUDENT_QUERY = "select student_id,student_branch,student_batch,student_name,student_approval_status from student";
	
	public static final String VIEW_COURSES_QUERY = "select course_code,course_name,course_isoffered,course_instructor,course_semester from course";
}
