package com.sports.dataOfMatches.dto;

import java.security.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {


	private String email;

	private String name;

	private String password;

	private Long phoneNo;

	@JsonIgnore
	private Timestamp createdAt;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "UserDto [email=" + email + ", name=" + name + ", password=" + password + ", phoneNo=" + phoneNo
				+ ", createdAt=" + createdAt + "]";
	}

	public UserDto(String email, String name, String password, Long phoneNo, Timestamp createdAt) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.phoneNo = phoneNo;
		this.createdAt = createdAt;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
