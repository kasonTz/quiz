package com.newer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="adminUsers")
public class AdminUser {

	@Id
	private String _id;
	@Field
	private String adminUserName;
	@Field
	private String adminPassword;
	
	public AdminUser() {}

	public AdminUser(String adminUserName, String adminPassword) {
		super();
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "AdminUser [_id=" + _id + ", adminUserName=" + adminUserName + ", adminPassword=" + adminPassword + "]";
	}
	
	
}
