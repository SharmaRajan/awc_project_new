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

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserResponse createUser(SignupRequest request) {

        UserResponse response = new UserResponse();

        User userNotWorking = userRepo.findByUsername(request.getUsername())
                .orElseThrow(() ->  new HandledException(HttpStatus.FOUND, "Username already exists"));

        userNotWorking.setUsername(request.getUsername());
        userNotWorking.setPassword(request.getPassword());
//        user.setCreatedOn();
//        user.setCreatedBy(user.getCreatedBy());
//        user.setApprovedBy();
        userNotWorking.setEmail(request.getEmailId());

        User savedUserNotWorking = userRepo.save(userNotWorking);

        response = this.modelMapper.map(savedUserNotWorking,UserResponse.class);

        return response;
    }
}
