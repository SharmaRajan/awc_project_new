package com.dalmia.crudapp.serviceImpl;

import com.dalmia.crudapp.entity.User;
import com.dalmia.crudapp.exceptions.HandledException;
import com.dalmia.crudapp.repository.IUserRepo;
import com.dalmia.crudapp.request.SignupRequest;
import com.dalmia.crudapp.response.UserResponse;
import com.dalmia.crudapp.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(SignupRequest request) {

        UserResponse response = new UserResponse();

        Optional<User> optionalUser = userRepo.findByUsername(request.getUsername());
//                .orElseThrow(() ->  new HandledException(HttpStatus.FOUND, "Username already exists"));

        User savedUserNotWorking = null;
        User theUser = new User();
        if (optionalUser.isEmpty()) {
            theUser.setUsername(request.getUsername());
            theUser.setPassword(passwordEncoder.encode(request.getPassword()));
            theUser.setEmail(request.getEmail());
            savedUserNotWorking = userRepo.save(theUser);
        }else{
            throw new HandledException(HttpStatus.FOUND, "Username already exists");
        }

        response = this.modelMapper.map(savedUserNotWorking, UserResponse.class);

        return response;
    }
}
