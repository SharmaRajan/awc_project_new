package com.dalmia.crudapp.controller;

import com.dalmia.crudapp.entity.User;
import com.dalmia.crudapp.request.LoginRequest;
import com.dalmia.crudapp.request.SignupRequest;
import com.dalmia.crudapp.response.JwtResponse;
import com.dalmia.crudapp.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {



    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/token")
    public ResponseEntity<JwtResponse> generateToken(@RequestBody LoginRequest loginRequest){
        String token = jwtUtils.generateToken(loginRequest.getUsername());

        JwtResponse response = new JwtResponse();
        response.setToken(token);
        response.setUsername(loginRequest.getUsername());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
