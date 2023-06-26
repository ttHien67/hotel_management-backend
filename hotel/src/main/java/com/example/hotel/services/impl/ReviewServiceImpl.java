package com.example.hotel.services.impl;

import com.example.hotel.mappers.ReviewMapper;
import com.example.hotel.models.request.ReviewRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.models.response.ReviewResponse;
import com.example.hotel.services.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements IReviewService {

    @Autowired
    private ReviewMapper mapper;

    public BaseResponse createReview(ReviewRequest request) {
        BaseResponse baseResponse = new BaseResponse();

        try{
            ReviewResponse response = mapper.create(request);

            if(response != null) {
                baseResponse = new BaseResponse(response, "0", "Create Successfully");
            }else {
                baseResponse = new BaseResponse("1", "Create Failure");
            }

        }catch (Exception e){
            return baseResponse;
        }

        return baseResponse;
    }

    public BaseResponse getReview(ReviewRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            List<ReviewResponse> response = mapper.get(request);
            if(response.size() != 0) {
                baseResponse = new BaseResponse(response, "0", "Get successfully");
                baseResponse.setTotalRecord(response.size());
            }else {
                baseResponse = new BaseResponse("1", "Get Failure");
            }
        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }
}
