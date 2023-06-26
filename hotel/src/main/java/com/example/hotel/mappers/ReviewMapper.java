package com.example.hotel.mappers;

import com.example.hotel.models.request.ReviewRequest;
import com.example.hotel.models.response.ReviewResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewMapper {
    public ReviewResponse create(ReviewRequest request);

    public List<ReviewResponse> get(ReviewRequest request);
}
