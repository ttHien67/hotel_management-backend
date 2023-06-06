package com.example.hotel.controllers;

import com.example.hotel.models.request.ContactRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {
    @Autowired
    private IContactService contactService;

    @GetMapping(value = "/getContact", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getContact(@RequestBody ContactRequest request){
        return new ResponseEntity<>(contactService.getContact(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createContact", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createContact(@RequestBody ContactRequest request){
        return new ResponseEntity<>(contactService.createContact(request), HttpStatus.OK);
    }

}
