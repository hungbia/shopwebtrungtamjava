package com.hungbia.shopweb.model;

import org.springframework.web.multipart.MultipartFile;

public class UserDTO {
	// class nay giong class trong entity nhung co the them thuoc tin
	// vidu them tt avatar de lay du lieu tu client gui len
	private int id;
	private String name;
	private int age;
	private String gender;
	private String username;
	private String password;
	private String email;
	private String role;
	private MultipartFile avatar;

	public UserDTO(int id, String name, int age, String gender, String username, String password, String email,
			String role, MultipartFile avatar) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.avatar = avatar;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public MultipartFile getAvatar() {
		return avatar;
	}

	public void setAvatar(MultipartFile avatar) {
		this.avatar = avatar;
	}

}
