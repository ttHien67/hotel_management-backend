package com.example.hotel.services.impl;

import com.example.hotel.mappers.ManagerMapper;
import com.example.hotel.models.request.ManagerRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.models.response.EmployeeResponse;
import com.example.hotel.models.response.ManagerResponse;
import com.example.hotel.services.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements IManagerService {
    @Autowired
    private ManagerMapper mapper;
    
    public BaseResponse getManager(ManagerRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int countManager = mapper.count(request);
            List<ManagerResponse> result = mapper.get(request);

            if(result != null) {
                baseResponse = new BaseResponse(result, "0", "Get Successfully");
                baseResponse.setTotalRecord(countManager);
            }else {
                baseResponse = new BaseResponse("1", "Get failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse updateManager(ManagerRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            ManagerResponse result = mapper.update(request);

            if(result != null) {
                baseResponse = new BaseResponse(result, "0", "Update Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Update failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse createManager(ManagerRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            ManagerResponse checkManagerExistion = mapper.checkManager(request.getCode());

            if(checkManagerExistion != null) {
                baseResponse = new BaseResponse("1", "Manager code has existed");
                return baseResponse;
            }
            ManagerResponse result = mapper.create(request);

            if(result != null) {
                baseResponse = new BaseResponse(result, "0", "Create Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Create failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }
}
