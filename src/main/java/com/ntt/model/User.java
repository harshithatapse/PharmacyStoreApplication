package com.ntt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ISADMIN")
	private String isAdmin;
	
	@Column(name = "EMAILID")
	private String emailId;
	
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "CONTACTNUMBER")
	private int contactNumber;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "PINCODE")
	private int pincode;
	
	public User() {
		super();
	}
	public User(long userId, String password, String userName, String isAdmin, String emailId, int age,
			int contactNumber, String city, String state, int pincode) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.isAdmin = isAdmin;
		this.emailId = emailId;
		this.age = age;
		this.contactNumber = contactNumber;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long UserId) {
		this.userId = UserId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
}