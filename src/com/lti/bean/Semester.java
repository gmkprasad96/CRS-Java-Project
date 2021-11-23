/**
 * 
 */
package com.lti.bean;

import java.util.List;

/**
 * @author user252
 *
 */
public class Semester {

	private int semId;
	private String semName;
	private List<Course> semesterCourses;
	/**
	 * @return the semId
	 */
	public int getSemId() {
		return semId;
	}
	/**
	 * @param semId the semId to set
	 */
	public void setSemId(int semId) {
		this.semId = semId;
	}
	/**
	 * @return the semName
	 */
	public String getSemName() {
		return semName;
	}
	/**
	 * @param semName the semName to set
	 */
	public void setSemName(String semName) {
		this.semName = semName;
	}
	/**
	 * @return the semesterCourses
	 */
	public List<Course> getSemesterCourses() {
		return semesterCourses;
	}
	/**
	 * @param semesterCourses the semesterCourses to set
	 */
	public void setSemesterCourses(List<Course> semesterCourses) {
		this.semesterCourses = semesterCourses;
	}
	
}
