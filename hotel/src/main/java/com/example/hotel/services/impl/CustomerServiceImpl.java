package com.example.hotel.services.impl;

import com.example.hotel.mappers.CustomerMapper;
import com.example.hotel.mappers.EmployeeMapper;
import com.example.hotel.models.request.CustomerRequest;
import com.example.hotel.models.request.EmployeeRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.models.response.CustomerResponse;
import com.example.hotel.models.response.EmployeeResponse;
import com.example.hotel.services.ICustomerService;
import com.example.hotel.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper mapper;

    public BaseResponse getCustomer(CustomerRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int countCustomer = mapper.count(request);
            CustomerResponse result = mapper.get(request);

            if(result != null) {
                baseResponse = new BaseResponse(result, "0", "Get Successsfully");
                baseResponse.setTotalRecord(countCustomer);
            }else {
                baseResponse = new BaseResponse("1", "Get failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse createCustomer(CustomerRequest request) {
        BaseResponse baseResponse = new BaseResponse();

        try{
            CustomerResponse checkCustomerExistion = mapper.checkCustomer(request.getIdCode());

            if(checkCustomerExistion != null) {
                baseResponse = new BaseResponse("1", "Customer code has existed");
                return baseResponse;
            }

            CustomerResponse result = mapper.create(request);
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

    public BaseResponse updateCustomer(CustomerRequest request) {
        BaseResponse baseResponse = new BaseResponse();

        try{
            CustomerResponse result = mapper.update(request);

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

    public BaseResponse deleteCustomer(CustomerRequest request) {
        BaseResponse baseResponse = new BaseResponse();

        try{
            CustomerResponse result = mapper.delete(request.getId());

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
