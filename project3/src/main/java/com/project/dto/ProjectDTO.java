package com.project.dto;

import java.util.Date;

public class ProjectDTO {

	private String id;
	private String passwd;
	private String email;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ProjectDTO [id=" + id + ", passwd=" + passwd + ", email=" + email + "]";
	}

}