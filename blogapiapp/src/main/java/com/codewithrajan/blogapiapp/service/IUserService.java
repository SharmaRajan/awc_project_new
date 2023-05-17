package com.codewithrajan.blogapiapp.service;

import com.codewithrajan.blogapiapp.payloads.UserDTO;

import java.util.List;

public interface IUserService {

	UserDTO registerNewUser(UserDTO newUser);

	UserDTO createUser(UserDTO theUser);
	
	UserDTO updateUser(UserDTO theUser, Integer userId);
	
	UserDTO getUserById(Integer userId);
	
	List<UserDTO> getAllUsers();
	
	void deleteUser(Integer userId);
	
}
