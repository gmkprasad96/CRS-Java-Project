package com.lti.bean;

import java.util.List;
/**
 * @author user250
 */

public class Student {
 
	public Student(){
	}
	public Student(int studentId, String branch, int batch,
			List<Course> primarySelectedCourses,
			List<Course> alternativeSelectedCourses) {
		super();
		this.studentId = studentId;
		this.branch = branch;
		this.batch = batch;
		this.primarySelectedCourses = primarySelectedCourses;
		this.alternativeSelectedCourses = alternativeSelectedCourses;
	}
	private int studentId;
	private String branch;
	private int batch;
	private List<Course> primarySelectedCourses;
	private List<Course> alternativeSelectedCourses;
	private String approvedStatus;
	private String studentName;
	/**
	 * @return the srollNo
	 */
	/**
	 * @return the primarySelectedCourses
	 */
	public List<Course> getPrimarySelectedCourses() {
		return primarySelectedCourses;
	}
	/**
	 * @param primarySelectedCourses the primarySelectedCourses to set
	 */
	public void setPrimarySelectedCourses(List<Course> primarySelectedCourses) {
		this.primarySelectedCourses = primarySelectedCourses;
	}
	/**
	 * @return the alternativeSelectedCourses
	 */
	public List<Course> getAlternativeSelectedCourses() {
		return alternativeSelectedCourses;
	}
	/**
	 * @param alternativeSelectedCourses the alternativeSelectedCourses to set
	 */
	public void setAlternativeSelectedCourses(
			List<Course> alternativeSelectedCourses) {
		this.alternativeSelectedCourses = alternativeSelectedCourses;
	}
	/**
	 * @return the report
	 */
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
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * @return the batch
	 */
	public int getBatch() {
		return batch;
	}
	/**
	 * @param batch the batch to set
	 */
	public void setBatch(int batch) {
		this.batch = batch;
	}
	/**
	 * @return the approvedStatus
	 */
	public String getApprovedStatus() {
		return approvedStatus;
	}
	/**
	 * @param approvedStatus the approvedStatus to set
	 */
	public void setApprovedStatus(String approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
