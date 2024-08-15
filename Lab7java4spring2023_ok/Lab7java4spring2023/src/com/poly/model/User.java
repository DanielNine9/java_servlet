package com.poly.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="userID")
	private String userID;
	@Column(name="admin")
	private boolean admin;
	@Column(name="email")
	private String email;
	@Column(name="fullName")
	private String fullName;
	@Column(name="password")
	private String password;

	public User() {
	}

	
	public User(String userID, boolean admin, String email, String fullName, String password) {
		this.userID = userID;
		this.admin = admin;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}


	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}