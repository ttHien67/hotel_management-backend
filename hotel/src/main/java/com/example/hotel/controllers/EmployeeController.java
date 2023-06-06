package com.example.hotel.controllers;

import com.example.hotel.models.request.EmployeeRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(value = "/getEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getEmployee(@RequestBody EmployeeRequest request) {
        return new ResponseEntity<>(employeeService.getEmployee(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createEmployee(@RequestBody  EmployeeRequest request) {
        return new ResponseEntity<>(employeeService.createEmployee(request), HttpStatus.OK);
    }

    @PutMapping(value = "/updateEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateEmployee(@RequestBody  EmployeeRequest request) {
        return new ResponseEntity<>(employeeService.updateEmployee(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteEmployee(@RequestBody  EmployeeRequest request) {
        return new ResponseEntity<>(employeeService.deleteEmployee(request), HttpStatus.OK);
    }
}
