package com.project.ElectricityBillingSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="login")
public class LoginEntity {
	
	@Id	
	@Email(message = "Email should be valid")
	@Column(length=50)
	private String email;

	@NotNull(message = "password is mandatory")
	private String password;
	
	@NotNull(message = "role is mandatory")
	private String role;

	@OneToOne(mappedBy = "loginEntity")
	private CustomerEntity customerEntity;
	
	public LoginEntity() {
		super();
	}

	public LoginEntity( String email, String password,String role) {
		super();
		this.email = email;
		this.password = password;
		this.role=role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "LoginEntity [email=" + email + ", password=" + password + ",role="+ role +"]";
	}

}
