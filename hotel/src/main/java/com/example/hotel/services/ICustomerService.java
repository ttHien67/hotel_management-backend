package com.example.hotel.services;

import com.example.hotel.models.request.CustomerRequest;
import com.example.hotel.models.response.BaseResponse;

public interface ICustomerService {

    BaseResponse getCustomer(CustomerRequest request);

    BaseResponse createCustomer(CustomerRequest request);

    BaseResponse updateCustomer(CustomerRequest request);

    BaseResponse deleteCustomer(CustomerRequest request);

}
