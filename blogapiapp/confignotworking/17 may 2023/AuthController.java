package com.codewithrajan.blogapiapp.controllers;

import com.codewithrajan.blogapiapp.exceptions.ApiException;
import com.codewithrajan.blogapiapp.payloads.JwtAuthResponse;
import com.codewithrajan.blogapiapp.payloads.UserDTO;
import com.codewithrajan.blogapiapp.request.AuthenticationRequest;
//import com.codewithrajan.blogapiapp.security.javainuse.JwtUtil;
import com.codewithrajan.blogapiapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtTokenHelper;
//    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private IUserService userService;

    // to authenticate username and password
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        this.authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());

        final UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = this.jwtTokenHelper.generateToken(userDetails);

        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                                        new UsernamePasswordAuthenticationToken(username,password);
        try{
            this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        }catch (DisabledException exc){
            throw new ApiException("User disabled..." + exc);
        } catch (BadCredentialsException exc){
            System.out.println("Bad credentials: Invalid details");
            throw new ApiException("Invalid username or password..." + exc);
        }
    }

    // register new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO theDto){
        UserDTO registeredUser = this.userService.registerNewUser(theDto);
        return new ResponseEntity<>(registeredUser,HttpStatus.CREATED);
    }


}
