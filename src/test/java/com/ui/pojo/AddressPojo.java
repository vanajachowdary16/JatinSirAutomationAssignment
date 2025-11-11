package com.ui.pojo;

public class AddressPojo {
	
	private String companyName;
	private String addressLine1;
	private String addressLine2;
	private String cityString;
	private String postCode;
	private String homePhoneNumber;
	private String mobileNumber;
	private String otherInformation;
	private String addressAlias;
	private String state;
	public AddressPojo(String companyName, String addressLine1, String addressLine2, String cityString, String postCode,
			String homePhoneNumber, String mobileNumber, String otherInformation, String addressAlias, String state) {
		super();
		this.companyName = companyName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.cityString = cityString;
		this.postCode = postCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobileNumber = mobileNumber;
		this.otherInformation = otherInformation;
		this.addressAlias = addressAlias;
		this.state = state;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getCityString() {
		return cityString;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public String getOtherInformation() {
		return otherInformation;
	}
	public String getAddressAlias() {
		return addressAlias;
	}
	public String getState() {
		return state;
	}
	@Override
	public String toString() {
		return "AddressPojo [companyName=" + companyName + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", cityString=" + cityString + ", postCode=" + postCode + ", homePhoneNumber="
				+ homePhoneNumber + ", mobileNumber=" + mobileNumber + ", otherInformation=" + otherInformation
				+ ", addressAlias=" + addressAlias + ", state=" + state + "]";
	}
	
	

}
