package com.example.hotel.mappers;

import com.example.hotel.models.request.EmployeeRequest;
import com.example.hotel.models.response.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeMapper {

    public int count(EmployeeRequest request);

    public List<EmployeeResponse> get(EmployeeRequest request);

    public EmployeeResponse checkEmployee(String request);

    public EmployeeResponse create(EmployeeRequest request);

    public EmployeeResponse update(EmployeeRequest request);

    public EmployeeResponse delete(String id);
}
