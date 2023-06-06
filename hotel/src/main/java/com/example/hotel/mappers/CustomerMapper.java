package com.example.hotel.mappers;

import com.example.hotel.models.request.CustomerRequest;
import com.example.hotel.models.response.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerMapper {

    public int count(CustomerRequest request);

    public CustomerResponse get(CustomerRequest request);

    public CustomerResponse checkCustomer(String idCode);

    public CustomerResponse create(CustomerRequest request);

    public CustomerResponse update(CustomerRequest request);

    public CustomerResponse delete(String id);
}
