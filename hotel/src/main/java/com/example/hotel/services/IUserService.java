package com.example.hotel.services;

import com.example.hotel.models.request.UserRequest;
import com.example.hotel.models.response.BaseResponse;
public interface IUserService {

    public BaseResponse createUser(UserRequest request);
}
