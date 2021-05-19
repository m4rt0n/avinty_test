package com.avinty.hr.model;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 20)
	private String username;

	@Column(length = 20)
	private String email;

	@Column(length = 20)
	private String password;

//	@Column(columnDefinition = "PrimitiveByteArrayBlobType")
	@Type(type = "org.hibernate.type.BinaryType")
	private Base64 profilePicture;

//---------------------------------------

	public User() {
	}

	public User(String username, String email, String password, Base64 profilePicture) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Base64 getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Base64 profilePicture) {
		this.profilePicture = profilePicture;
	}
}
