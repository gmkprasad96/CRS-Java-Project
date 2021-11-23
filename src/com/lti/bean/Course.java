/**
 * 
 */
package com.lti.bean;

import java.util.List;

/**
 * @author user252
 *
 */
public class Course {

	private int courseId;
	private String courseCode;
	private String name;
	private boolean isOffered;
	private String instructor;
	private String offeredStatus;
	/**
	 * @return the courseId
	 */
	private int semester;
	
	public Course(){
		
	}
	public int getCourseId() {
		return courseId;
	}
	
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}
	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the isOffered
	 */
	public boolean isOffered() {
		return isOffered;
	}
	/**
	 * @param isOffered the isOffered to set
	 */
	public void setOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}
	/**
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}
	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
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

	public Course(String courseCode, String name,
			boolean isOffered, String instructor, int semester) {
		super();
		this.courseCode = courseCode;
		this.name = name;
		this.isOffered = isOffered;
		this.instructor = instructor;
		this.semester = semester;
	}
	/**
	 * @return the offeredStatus
	 */
	public String getOfferedStatus() {
		return offeredStatus;
	}
	/**
	 * @param offeredStatus the offeredStatus to set
	 */
	public void setOfferedStatus(String offeredStatus) {
		this.offeredStatus = offeredStatus;
	}
}
