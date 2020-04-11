package com.hungbia.shopweb.service;

import java.util.List;

import com.hungbia.shopweb.model.UserDTO;

public interface UserSevice {
	public void addUser(UserDTO uSerDTO);

	public void deleteUserDTO(int id);

	public void updateUserDTO(UserDTO uSerDTO);

	public UserDTO getUserIdDTO(int id);

	public List<UserDTO> getAllUserDTO();

	public UserDTO searchUsername(String username);

	public List<UserDTO> searchRole(String role);

	public List<UserDTO> searchName(String keyword);

}
