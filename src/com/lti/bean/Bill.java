/**
 * 
 */
package com.lti.bean;

import java.util.Date;

/**
 * @author user252
 *
 */
public class Bill {

	private int bId;
	private double bAmount;
	private Date bDate;
	
	/**
	 * @return the bId
	 */
	public int getbId() {
		return bId;
	}
	/**
	 * @param bId the bId to set
	 */
	public void setbId(int bId) {
		this.bId = bId;
	}
	/**
	 * @return the bAmount
	 */
	public double getbAmount() {
		return bAmount;
	}
	/**
	 * @param bAmount the bAmount to set
	 */
	public void setbAmount(double bAmount) {
		this.bAmount = bAmount;
	}
	/**
	 * @return the bDate
	 */
	public Date getbDate() {
		return bDate;
	}
	/**
	 * @param bDate the bDate to set
	 */
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	
}
