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
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserResponse createUser(SignupRequest request) {

        UserResponse response = new UserResponse();

        User user = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() ->  new HandledException(HttpStatus.FOUND, "Username already exists"));

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
//        user.setCreatedOn();
//        user.setCreatedBy(user.getCreatedBy());
//        user.setApprovedBy();
        user.setEmailId(request.getEmailId());

        User savedUser = userRepo.save(user);

        response = this.modelMapper.map(savedUser,UserResponse.class);

        return response;
    }
}
