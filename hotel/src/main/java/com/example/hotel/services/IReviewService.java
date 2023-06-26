package com.example.hotel.services;

import com.example.hotel.models.request.ReviewRequest;
import com.example.hotel.models.response.BaseResponse;

public interface IReviewService {
    public BaseResponse createReview(ReviewRequest request);

    public  BaseResponse getReview(ReviewRequest request);
}
