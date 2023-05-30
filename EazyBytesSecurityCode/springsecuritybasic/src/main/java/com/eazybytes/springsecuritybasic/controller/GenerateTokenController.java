package com.eazybytes.springsecuritybasic.controller;

import com.eazybytes.springsecuritybasic.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/token")
public class GenerateTokenController {

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate")
    public ResponseEntity<HashMap<String,String>> generateToken(@RequestBody String username){

        String token = jwtUtils.generateToken(username);
        HashMap<String,String> response = new HashMap<>();
        response.put("token:", token);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
