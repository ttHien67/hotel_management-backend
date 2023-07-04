package com.example.hotel.services.impl;

import com.example.hotel.mappers.UserMapper;
import com.example.hotel.models.request.UserRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.models.response.UserResponse;
import com.example.hotel.services.IUserService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    public BaseResponse createUser(UserRequest request) {
        try{
            if (request == null || Strings.isNullOrEmpty(request.getFullName())
                    || Strings.isNullOrEmpty(request.getUserName()) || Strings.isNullOrEmpty(request.getEmail())
                    || Strings.isNullOrEmpty(request.getPassword())) {
                return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                        "Fiels is requried");
            }
            UserResponse checkEmailExistion = mapper.checkEmailExistion(request);
            if(checkEmailExistion != null) {
                return new BaseResponse("1", "Email already in use");
            }

            String hashedPassword = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(10));
            request.setPassword(hashedPassword);

            UserResponse result = mapper.create(request);
            if(result != null) {
                return new BaseResponse(result, "0", "Account have been created");
            }else {
                return new BaseResponse("1", "Something is false");
            }
        }catch (Exception e){
            return new BaseResponse("1", "Failure");
        }
    }
}
