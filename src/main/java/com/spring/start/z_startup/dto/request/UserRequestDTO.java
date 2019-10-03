package com.spring.start.z_startup.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequestDTO {

	@NotNull
	@Size(max = 20, min = 5, message = "Name should have atleast 5 and atmax 20 characters.")
	private String name;
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9_.-]+@[A-Za-z0-9_.-]+$", message = "Email is not of proper format(e.g abc@domain.com)")
	private String email;
	@NotNull
	@Size(max = 20, min = 5, message = "Password should have atleast 5 and atmax 20 characters.")
	private String password;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
}
