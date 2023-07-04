package com.example.hotel.mappers;

import com.example.hotel.models.request.UserRequest;
import com.example.hotel.models.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper {

    UserResponse checkEmailExistion(UserRequest request);

    UserResponse create(UserRequest request);
}
