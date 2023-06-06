package com.example.hotel.services;

import com.example.hotel.models.request.EmployeeRequest;
import com.example.hotel.models.response.BaseResponse;

public interface IEmployeeService {

    public BaseResponse getEmployee(EmployeeRequest request);

    public BaseResponse createEmployee(EmployeeRequest request);

    public BaseResponse updateEmployee(EmployeeRequest request);

    public BaseResponse deleteEmployee(EmployeeRequest request);

}
