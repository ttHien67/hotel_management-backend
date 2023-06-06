package com.example.hotel.services.impl;

import com.example.hotel.mappers.ContactMapper;
import com.example.hotel.models.request.ContactRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.models.response.ContactResponse;
import com.example.hotel.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements IContactService {

    @Autowired
    private ContactMapper mapper;

    public BaseResponse getContact(ContactRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            int countCustomer = mapper.count(request);
            List<ContactResponse> result = mapper.get(request);

            if(result != null) {
                baseResponse = new BaseResponse(result, "0", "Get Successsfully");
                baseResponse.setTotalRecord(countCustomer);
            }else {
                baseResponse = new BaseResponse("1", "Get failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse createContact(ContactRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            ContactResponse result = mapper.create(request);

            if(result != null) {
                baseResponse = new BaseResponse(result, "0", "Create Successsfully");
            }else {
                baseResponse = new BaseResponse("1", "Create failure");
            }

        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }
}
