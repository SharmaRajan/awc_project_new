package com.dalmia.crudapp.service;

import com.dalmia.crudapp.request.SignupRequest;
import com.dalmia.crudapp.response.UserResponse;

public interface IUserService  {

    UserResponse createUser(SignupRequest request);



}
