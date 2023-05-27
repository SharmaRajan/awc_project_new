package com.dalmia.crudapp.service;

import com.dalmia.crudapp.entity.User;
import com.dalmia.crudapp.request.SignupRequest;
import com.dalmia.crudapp.response.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserService  {

    UserResponse createUser(SignupRequest request);


}
