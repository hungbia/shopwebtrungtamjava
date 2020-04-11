package com.hungbia.shopweb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
//class entity nay co dinh theo bang trong CSDL
public class User implements Serializable {
	// can khi luu hoac chuyen du lieu qua mang
	/**
	 */
	private static final long serialVersionUID = 1L;

	// de autu id tu tang dung
	// indenity thi id tu tang
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id // khoa chinh
	@Column(name = "id")
	private int id;

	@Column(name = "name") // ten cot trong bang ma trung voi bien thi k can @ colum
	private String name;
	private int age;
	private String gender;
	private String username;
	private String password;
	private String email;
	private String role;

	public User(int id, String name, int age, String gender, String username, String password, String email,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public User() {
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

}
