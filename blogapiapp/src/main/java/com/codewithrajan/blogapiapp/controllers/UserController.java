package com.codewithrajan.blogapiapp.controllers;


import com.codewithrajan.blogapiapp.payloads.ApiResponse;
import com.codewithrajan.blogapiapp.payloads.UserDTO;
import com.codewithrajan.blogapiapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private IUserService userService;
	
	
	// POST - create User
	@PostMapping("/lists")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO theDto){
		UserDTO createdUserDTO = userService.createUser(theDto);
		return new ResponseEntity<>(createdUserDTO,HttpStatus.CREATED);
	}
	
	// PUT - update User
	@PutMapping("/lists/{id}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO theDto, @PathVariable Integer id){
		UserDTO updatedUser = this.userService.updateUser(theDto, id);
		return ResponseEntity.ok(updatedUser);
	}

	// ADMIN
	// DELETE - delete User
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/lists/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
//		return new ResponseEntity<>(Map.of("message","User Deleted successfully"),HttpStatus.OK);
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	
	// GET - get User
	@GetMapping("/lists")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> usrListsDtos = this.userService.getAllUsers();
		return new ResponseEntity<>(usrListsDtos,HttpStatus.OK);
	}
	
	@GetMapping("/lists/{userId}")
	public ResponseEntity<UserDTO> getSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
}
