package com.lti.sqlconstant;

/**
 * @author user250
 */

public class StudentQuery {

	
	
	public static final String ADD_STUDENT="insert into student (student_id,student_branch,student_batch,student_name,student_approval_status) values (?,?,?,?,?)";
	public static final String ADD_COURSE="insert into studentcoursecatalog (course_id,course_code,course_name,course_isoffered,course_instructor,course_semester) values ( ?,?,?,?,?,? )";
	public static final String DROP_COURSE="delete from studentcoursemapping where student_id=? and course_code=?";
	public static final String VIEW_COURSES="SELECT * FROM studentcoursemapping where student_id=";
	public static final String INSERT_COURSES="insert into studentcoursemapping values (?,?)";
}
