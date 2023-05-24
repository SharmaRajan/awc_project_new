package com.codewithrajan.blogapiapp.service.impl;


import com.codewithrajan.blogapiapp.dtoConversion.UserDTOConversion;
import com.codewithrajan.blogapiapp.entities.Role;
import com.codewithrajan.blogapiapp.entities.User;
import com.codewithrajan.blogapiapp.exceptions.ResourceNotFoundException;
import com.codewithrajan.blogapiapp.helper.AppConstants;
import com.codewithrajan.blogapiapp.payloads.UserDTO;
import com.codewithrajan.blogapiapp.repository.IRoleRepo;
import com.codewithrajan.blogapiapp.repository.IUserRepo;
import com.codewithrajan.blogapiapp.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo userRepo;
	
	@Autowired
	private UserDTOConversion conversion;

	@Autowired
	private ModelMapper modelMapper;

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	@Autowired
	private IRoleRepo roleRepo;

	@Override
	public UserDTO registerNewUser(UserDTO newUserDTO) {

		User theUser = this.modelMapper.map(newUserDTO,User.class);

		// 1. take care of passwords
		// encoded the password
//		theUser.setPassword(passwordEncoder.encode(newUserDTO.getPassword()));
		theUser.setPassword(newUserDTO.getPassword());
		// 2. take care of roles
		Role theRole = this.roleRepo.findById(AppConstants.NORMAL_USER).get();

		theUser.getRoles().add(theRole);
		User newUser = this.userRepo.save(theUser);

		return this.modelMapper.map(newUser,UserDTO.class);
	}

	@Override
	public UserDTO createUser(UserDTO theUserDto) {
		
		// another alternative is ModelMapper
		//UserDTOConversion conversion = new UserDTOConversion();
		
		// convert the dto to entity
		User theUser = conversion.dtoToUser(theUserDto);
		
		// save the user
		User savedUser = this.userRepo.save(theUser);
		
		// return the conversion dto of saved user entity
		return conversion.userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO theUserDto, Integer userId) {
		
		User theUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id ",userId));
		
		theUser.setName(theUserDto.getName());
		theUser.setEmail(theUserDto.getEmail());
		theUser.setPassword(theUserDto.getPassword());
		theUser.setAbout(theUserDto.getAbout());
		
		User savedUser = this.userRepo.save(theUser);
		
		// convert entity to dto to transfer the response
		//UserDTOConversion conversion = new UserDTOConversion();
		UserDTO theDto = conversion.userToDto(savedUser);
		
		return theDto;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		
		User theUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id ",userId));
		
		// convert entity to dto to transfer the response
		//UserDTOConversion conversion = new UserDTOConversion();
		
		// directly use model mapper now
		UserDTO userDTO = conversion.userToDto(theUser);
		
		return userDTO;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		
		List<User> users = this.userRepo.findAll();
		
		//UserDTOConversion conversion = new UserDTOConversion();
		
		List<UserDTO> userDtoList =  users.stream()
				.map(user -> conversion.userToDto(user)).collect(Collectors.toList());
		
		return userDtoList;
		
	}

	@Override
	public void deleteUser(Integer userId) {

		User theUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id ",userId));
		
		userRepo.delete(theUser);
		
	}

}
