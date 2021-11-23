/**
 * 
 */
package com.lti.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.GradeCard;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.dao.AdminInterfaceDao;
import com.lti.dao.AdminOperationDao;
import com.lti.exception.CourseFoundinCatalagException;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.GradeNotFoundException;
import com.lti.exception.UserIdAlreadyExistedException;
import com.lti.exception.UserNotFoundException;

/**
 * @author user252
 *
 */
public class AdminOperations implements AdminInterface{

	
	/* (non-Javadoc)
	 * @see com.lti.service.AdminInterface#addProfessor()
	 */
	
	AdminInterfaceDao dao = new AdminOperationDao();
	@Override
	public void addProfessor(Professor newProf) {
		// TODO Auto-generated method stub
		boolean professorExists = dao.isProfExists(newProf.getProfessorId());
		if(professorExists){
			try {
				throw new UserIdAlreadyExistedException(newProf.getProfessorName());
			} catch (UserIdAlreadyExistedException e) {
				// TODO Auto-generated catch block
			}
		}else{
			dao.addProfessor(newProf);
			System.out.println("Course is added successfully");
		}
	}

	

	/* (non-Javadoc)
	 * @see com.lti.service.AdminInterface#approveStudentRegistration()
	 */
	@Override
	public void approveStudentRegistration(List<Student> studentsForRegistration) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Students for approval are:");
			studentsForRegistration.forEach(S->System.out.println(S));
			for(Student std: studentsForRegistration) {
				int count = dao.approveStudents(std);
				if(count==0) {
					throw new UserNotFoundException(std.getStudentName());
				}
			}
		}
		catch(UserNotFoundException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.lti.service.AdminInterface#addCoursesInCatalogue(java.util.List)
	 */
	@Override
	public void addCoursesInCatalogue(Course newCourse) {
		// TODO Auto-generated method stub
		
		boolean courseExists = dao.isCourseExists(newCourse.getCourseCode());
		if(courseExists){
			try {
				throw new CourseFoundinCatalagException(newCourse.getCourseCode());
			} catch (CourseFoundinCatalagException e) {
				// TODO Auto-generated catch block
			}
		}else{
			dao.addCourse(newCourse);
			System.out.println("Course is added successfully");
		}
	}

	/* (non-Javadoc)
	 * @see com.lti.service.AdminInterface#removeCoursesFromCatalogue(java.util.List)
	 */
	@Override
	public void removeCoursesFromCatalogue(Course course) {
		// TODO Auto-generated method stub
		try {
			boolean courseExists = dao.isCourseExists(course.getCourseCode());
			if(courseExists){
				String courseCode = course.getCourseCode();
				dao.removeCourse(courseCode);
			}
		}
		catch(CourseNotFoundException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void generateReportCard(int studentId, int semester) {
		// TODO Auto-generated method stub
		try {
			GradeCard gc = dao.getGradeCard(studentId,semester);
			if(gc!=null) {
			       System.out.println("cardId: "+gc.getCardId());
			       System.out.println("semester: "+gc.getSemester());
			       System.out.println("cpi: "+gc.getCpi());
			       System.out.println("student id: "+gc.getStudentId());
			     
			}
			else {
				throw new GradeNotFoundException(studentId);
			}
		}
		catch(GradeNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
