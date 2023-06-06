package com.example.hotel.services.impl;

import com.example.hotel.mappers.EmployeeMapper;
import com.example.hotel.models.request.EmployeeRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.models.response.EmployeeResponse;
import com.example.hotel.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    public BaseResponse getEmployee(EmployeeRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int countEmployee = mapper.count(request);
            List<EmployeeResponse> result = mapper.get(request);

            if(result != null) {
                baseResponse = new BaseResponse(result, "0", "Get Successsfully");
                baseResponse.setTotalRecord(countEmployee);
            }else {
                baseResponse = new BaseResponse("1", "Get failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse createEmployee(EmployeeRequest request) {
        BaseResponse baseResponse = new BaseResponse();

        try{
            EmployeeResponse checkEmployeeExistion = mapper.checkEmployee(request.getCode());

            if(checkEmployeeExistion != null) {
                baseResponse = new BaseResponse("1", "Employee code has existed");
                return baseResponse;
            }

            EmployeeResponse result = mapper.create(request);
            if(result != null) {
                baseResponse = new BaseResponse(request, "0", "Create Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Create Failure");
            }


        }catch (Exception e) {
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse updateEmployee(EmployeeRequest request) {
        BaseResponse baseResponse = new BaseResponse();

        try{
            EmployeeResponse result = mapper.update(request);

            if(result != null) {
                baseResponse = new BaseResponse(result, "0", "Update Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Update Failure");
            }


        }catch (Exception e) {
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse deleteEmployee(EmployeeRequest request) {
        BaseResponse baseResponse = new BaseResponse();

        try{
            EmployeeResponse result = mapper.delete(request.getId());

            if(result != null) {
                baseResponse = new BaseResponse(result, "0", "Delete Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Delete Failure");
            }


        }catch (Exception e) {
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }
}
