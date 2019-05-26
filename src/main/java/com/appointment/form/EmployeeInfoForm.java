package com.appointment.form;

public class EmployeeInfoForm {

	private String name;
	private String mobileNo;
	private String emailAddress;
	private String addressLine1;
	private String addressLine2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Override
	public String toString() {
		return "EmployeeInfoForm [name=" + name + ", mobileNo=" + mobileNo + ", emailAddress=" + emailAddress
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + "]";
	}

}
