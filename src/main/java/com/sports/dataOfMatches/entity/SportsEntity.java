package com.sports.dataOfMatches.entity;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SportsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String email;

	private String name;

	private String password;

	private Long phoneNo;

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

	public SportsEntity(String email, String name, String password, Long phoneNo, Timestamp createdAt) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.phoneNo = phoneNo;
		this.createdAt = createdAt;
	}
	
}
