package com.example.hotel.controllers;

import com.example.hotel.models.request.ManagerRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.services.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {
    
    @Autowired
    private IManagerService managerService;
    
    @GetMapping(value = "/getManager", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getManager(@RequestBody ManagerRequest request) {
        return new ResponseEntity<>(managerService.getManager(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createManager", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createManager(@RequestBody ManagerRequest request) {
        return new ResponseEntity<>(managerService.createManager(request), HttpStatus.OK);
    }

    @PutMapping(value = "/updateManager", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateManager(@RequestBody ManagerRequest request) {
        return new ResponseEntity<>(managerService.updateManager(request), HttpStatus.OK);
    }
}
