package com.hungbia.shopweb.dao;

import java.util.List;

import com.hungbia.shopweb.entity.User;

public interface UserDao {

	public void add(User user);

	public void update(User user);

	public void delete(User user);

	public User getUserByID(int id);

	public List<User> getAllUser();

	public User searchUsername(String username);

	public List<User> searchRole(String role);

	public List<User> searchName(String keyword);

}
