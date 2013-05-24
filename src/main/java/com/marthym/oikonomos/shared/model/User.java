package com.marthym.oikonomos.shared.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.marthym.oikonomos.shared.FieldVerifier;

@Entity
@Table(name = "USER")
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 8367354503151607136L;

	@Id
	@Column(name = "user_id", nullable = false, length = 255)
	@NotNull
	@Pattern(regexp = FieldVerifier.EMAIL_REGEXP, message="{validator.message.user.email}")
	private String userId;

	@Column(name = "user_firstname", nullable = false, length = 80)
	@NotNull
	private String userFirstname;
	@Column(name = "user_lastname", nullable = false, length = 80)
	@Size(min = 3, max = 80, message="{validator.message.user.lastname}")
	private String userLastname;
	@Column(name = "user_password", nullable = false, length = 40)
	private String userPassword;
	@Column(name = "user_registration_date", nullable = false)
	private Date userRegistrationDate;
	@Column(name = "user_lastlogin_date", nullable = false)
	private Date userLastLoginDate;

	public User() {
	}

	public User(String userId) {
		this.userId = userId;
	}

	public User(String userId, String userFirstname, String userLastname,
			String userPassword, Date userRegistrationDate,
			Date userLastLoginDate) {
		this.userId = userId;
		this.userFirstname = userFirstname;
		this.userLastname = userLastname;
		this.userPassword = userPassword;
		this.userRegistrationDate = userRegistrationDate;
		this.userLastLoginDate = userLastLoginDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserFirstname() {
		return userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public String getUserLastname() {
		return userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getUserRegistrationDate() {
		return userRegistrationDate;
	}

	public void setUserRegistrationDate(Date userRegistrationDate) {
		this.userRegistrationDate = userRegistrationDate;
	}

	public Date getUserLastLoginDate() {
		return userLastLoginDate;
	}

	public void setUserLastLoginDate(Date userLastLoginDate) {
		this.userLastLoginDate = userLastLoginDate;
	}

}
