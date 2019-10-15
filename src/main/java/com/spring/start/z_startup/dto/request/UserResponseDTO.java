package com.spring.start.z_startup.dto.request;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.spring.start.z_startup.entity.UserPermissionEnum;
import com.spring.start.z_startup.entity.UserStatusEnum;

@JsonInclude(Include.NON_NULL)
public class UserResponseDTO {

	private Integer id;
	private String token;
	private String name;
	private String email;
	private String password;
	private Boolean isEmailVerified;
	private String code;
	private com.spring.start.z_startup.entity.UserStatusEnum status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastUpdatedAt;
	
    private Set<com.spring.start.z_startup.entity.UserPermissionEnum> permissions;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String userName) {
		this.email = userName;
	}
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
	/**
	 * @return the isEmailVerified
	 */
	public Boolean getIsEmailVerified() {
		return isEmailVerified;
	}
	/**
	 * @param isEmailVerified the isEmailVerified to set
	 */
	public void setIsEmailVerified(Boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the status
	 */
	public UserStatusEnum getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(UserStatusEnum status) {
		this.status = status;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the lastUpdatedAt
	 */
	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}
	/**
	 * @param lastUpdatedAt the lastUpdatedAt to set
	 */
	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}
	/**
	 * @return the permissions
	 */
	public Set<UserPermissionEnum> getPermissions() {
		return permissions;
	}
	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(Set<UserPermissionEnum> permissions) {
		this.permissions = permissions;
	}
	
}
