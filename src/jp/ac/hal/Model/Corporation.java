package jp.ac.hal.Model;

import java.sql.Date;

public class Corporation {
	
	private int corporationId;
	private String corporationName;
	private String postalCode;
	private String address;
	private String phoneNumber;
	private String passwd;
	private int creditLimit;
	private Date registDate;
	private int corporationAccountId;
	private String corporationAccountName;
	private String state;
	private int orderId;
	private Date estimateDate; 
	
	public int getCorporationId() {
		return corporationId;
	}
	public void setCorporationId(int corporationId) {
		this.corporationId = corporationId;
	}
	public String getCorporationName() {
		return corporationName;
	}
	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public int getCorporationAccountId() {
		return corporationAccountId;
	}
	public void setCorporationAccountId(int corporationAccountId) {
		this.corporationAccountId = corporationAccountId;
	}
	public String getCorporationAccountName() {
		return corporationAccountName;
	}
	public void setCorporationAccountName(String corporationAccountName) {
		this.corporationAccountName = corporationAccountName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getEstimateDate() {
		return estimateDate;
	}
	public void setEstimateDate(Date estimateDate) {
		this.estimateDate = estimateDate;
	}
}
