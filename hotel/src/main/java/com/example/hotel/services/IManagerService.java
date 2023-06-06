package com.example.hotel.services;

import com.example.hotel.models.request.ManagerRequest;
import com.example.hotel.models.response.BaseResponse;
import org.springframework.stereotype.Service;

public interface IManagerService {
    
    public BaseResponse getManager(ManagerRequest request);

    public BaseResponse createManager(ManagerRequest request);

    public BaseResponse updateManager(ManagerRequest request);
}
