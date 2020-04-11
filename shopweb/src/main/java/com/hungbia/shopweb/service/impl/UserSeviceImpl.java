package com.hungbia.shopweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hungbia.shopweb.dao.UserDao;
import com.hungbia.shopweb.entity.User;
import com.hungbia.shopweb.model.UserDTO;
import com.hungbia.shopweb.service.UserSevice;

@Transactional
@Service
public class UserSeviceImpl implements UserSevice {
//convert giua lop User va user DTO

	@Autowired
	UserDao userDao;

	@Override
	public void addUser(UserDTO uSerDTO) {
		// set entity lay tu model model
		User user = new User();
		user.setName(uSerDTO.getName());
		user.setAge(uSerDTO.getAge());
		user.setEmail(uSerDTO.getEmail());
		user.setUsername(uSerDTO.getUsername());
		user.setPassword(uSerDTO.getPassword());
		user.setRole(uSerDTO.getRole());
		user.setGender(uSerDTO.getGender());
		userDao.add(user);

	}

	@Override
	public void deleteUserDTO(int id) {
		User user = new User();
		user = userDao.getUserByID(id);
		if (user != null) {
			userDao.delete(user);
		}

	}

	@Override
	public void updateUserDTO(UserDTO uSerDTO) {
		User user = userDao.getUserByID(uSerDTO.getId());
		if (user != null) {

			user.setName(uSerDTO.getName());
			user.setAge(uSerDTO.getAge());
			user.setEmail(uSerDTO.getEmail());
			user.setUsername(uSerDTO.getUsername());
			user.setPassword(uSerDTO.getPassword());
			user.setRole(uSerDTO.getRole());
			user.setGender(uSerDTO.getGender());
			userDao.update(user);
		}

	}

	@Override
	public UserDTO getUserIdDTO(int id) {
		User user = userDao.getUserByID(id);
		UserDTO dto = new UserDTO();
		// lay doi tuong tu bang len set nguoc lai cho view
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setAge(user.getAge());
		dto.setEmail(user.getEmail());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setRole(user.getRole());
		dto.setGender(user.getGender());

		return dto;
	}

	@Override
	public List<UserDTO> getAllUserDTO() {
		List<User> users = new ArrayList<User>();
		users = userDao.getAllUser();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO dto = new UserDTO();
			dto.setId(user.getId());
			dto.setName(user.getName());
			dto.setAge(user.getAge());
			dto.setEmail(user.getEmail());
			dto.setUsername(user.getUsername());
			dto.setPassword(user.getPassword());
			dto.setRole(user.getRole());
			dto.setGender(user.getGender());
			userDTOs.add(dto);
		}

		return userDTOs;
	}

	@Override
	public UserDTO searchUsername(String username) {
		User user = userDao.searchUsername(username);
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setAge(user.getAge());
		dto.setEmail(user.getEmail());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		dto.setRole(user.getRole());
		dto.setGender(user.getGender());

		return dto;
	}

	@Override
	public List<UserDTO> searchRole(String role) {
		List<User> users = new ArrayList<User>();
		users = userDao.searchRole(role);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO dto = new UserDTO();
			dto.setId(user.getId());
			dto.setName(user.getName());
			dto.setAge(user.getAge());
			dto.setEmail(user.getEmail());
			dto.setUsername(user.getUsername());
			dto.setPassword(user.getPassword());
			dto.setRole(user.getRole());
			dto.setGender(user.getGender());
			userDTOs.add(dto);
		}

		return userDTOs;
	}

	@Override
	public List<UserDTO> searchName(String keyword) {
		List<User> users = new ArrayList<User>();
		users = userDao.searchName(keyword);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO dto = new UserDTO();
			dto.setId(user.getId());
			dto.setName(user.getName());
			dto.setAge(user.getAge());
			dto.setEmail(user.getEmail());
			dto.setUsername(user.getUsername());
			dto.setPassword(user.getPassword());
			dto.setRole(user.getRole());
			dto.setGender(user.getGender());
			userDTOs.add(dto);
		}

		return userDTOs;
	}

}
