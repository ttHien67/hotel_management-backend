package com.example.hotel.services;

import com.example.hotel.models.request.ContactRequest;
import com.example.hotel.models.response.BaseResponse;

public interface IContactService {

    public BaseResponse getContact(ContactRequest request);

    public BaseResponse createContact(ContactRequest request);
}
