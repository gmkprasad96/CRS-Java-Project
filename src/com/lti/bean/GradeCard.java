/**
 * 
 */
package com.lti.bean;

import java.util.List;

/**
 * @author user252
 *
 */
public class GradeCard {

	private int cardId;
	private int studentId;
	private int semester;
	private double cpi;
	private List<Course> registeredCourses;
	/**
	 * @return the studentId
	 */
	
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}
	/**
	 * @return the cpi
	 */
	public double getCpi() {
		return cpi;
	}
	/**
	 * @param cpi the cpi to set
	 */
	public void setCpi(double cpi) {
		this.cpi = cpi;
	}
	/**
	 * @return the registeredCourses
	 */
	public List<Course> getRegisteredCourses() {
		return registeredCourses;
	}
	/**
	 * @param registeredCourses the registeredCourses to set
	 */
	public void setRegisteredCourses(List<Course> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	/**
	 * @return the cardId
	 */
	public int getCardId() {
		return cardId;
	}
	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	
}
