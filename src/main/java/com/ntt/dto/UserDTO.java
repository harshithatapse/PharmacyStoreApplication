package com.ntt.dto;

public class UserDTO {
	
	private long userId;
	private String userName;
	private String password;
	private String isAdmin;
	private String emailId;
	private int age;
	private int contactNumber;
	private String city;
	private String state;
	private int pincode;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	public UserDTO(long userId, String userName, String password, String isAdmin, String emailId, int age,
			int contactNumber, String city, String state, int pincode) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.emailId = emailId;
		this.age = age;
		this.contactNumber = contactNumber;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public UserDTO() {
		super();
		
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", isAdmin="
				+ isAdmin + ", emailId=" + emailId + ", age=" + age + ", contactNumber=" + contactNumber + ", city="
				+ city + ", state=" + state + ", pincode=" + pincode + "]";
	}

}
