package com.demo.skeleton_rest.persistance.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="Id user")
	@Id
	private int id;
	
	@ApiModelProperty(notes="Name of user")
	@Field
	private String name;
	
	@ApiModelProperty(notes="Email of user")
	@Field
	private String email;
	
	@ApiModelProperty(notes="Login of user")
	@Field
	private String login;
	
	@ApiModelProperty(notes="Password of user")
	@Field
	private String password;
	
	@ApiModelProperty(notes="Authority of user")
	@Field
	private String authority;

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", login=" + login + ", password=" + password
				+ "]";
	}
	

}
