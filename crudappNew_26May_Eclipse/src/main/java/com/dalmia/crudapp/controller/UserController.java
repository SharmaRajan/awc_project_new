package com.dalmia.crudapp.controller;

import com.dalmia.crudapp.repository.IUserRepo;
import com.dalmia.crudapp.request.SignupRequest;
import com.dalmia.crudapp.request.UserRequest;
import com.dalmia.crudapp.response.UserResponse;
import com.dalmia.crudapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> createUser(@RequestBody SignupRequest userRequest){
        UserResponse response = userService.createUser(userRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
