/**
 * 
 */
package com.lti.bean;

/**
 * @author user252
 *
 */
public class OnlinePayment extends Payment{

	private String bankName;

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
