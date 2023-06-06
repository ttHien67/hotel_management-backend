package com.example.hotel.mappers;

import com.example.hotel.models.request.ContactRequest;
import com.example.hotel.models.response.ContactResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactMapper {
    public int count(ContactRequest request);

    public List<ContactResponse> get(ContactRequest request);

    public ContactResponse create(ContactRequest request);
}
