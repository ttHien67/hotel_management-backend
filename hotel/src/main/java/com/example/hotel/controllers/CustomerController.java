package com.example.hotel.controllers;

import com.example.hotel.models.request.CustomerRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = "/getCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getCustomer(@RequestBody CustomerRequest request) {
        return new ResponseEntity<>(customerService.getCustomer(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createCustomer(@RequestBody CustomerRequest request) {
        return new ResponseEntity<>(customerService.createCustomer(request), HttpStatus.OK);
    }

    @PutMapping(value = "/updateCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateCustomer(@RequestBody CustomerRequest request) {
        return new ResponseEntity<>(customerService.updateCustomer(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteCustomer(@RequestBody CustomerRequest request) {
        return new ResponseEntity<>(customerService.deleteCustomer(request), HttpStatus.OK);
    }
}
