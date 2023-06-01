package com.dalmia.crudapp.controller;

import com.dalmia.crudapp.entity.User;
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

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody SignupRequest userRequest){
        UserResponse response = userService.createUser(userRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /*@PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody SignupRequest signupRequest){
        UserResponse savedCustomer = null;
        ResponseEntity response = null;

        try{
            savedCustomer = userService.createUser(signupRequest);
            if(savedCustomer.getId() > 0){
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        }catch (Exception exc){
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + exc.getMessage());
        }
        return response;
    }
*/

}
