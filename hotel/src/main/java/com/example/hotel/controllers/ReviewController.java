package com.example.hotel.controllers;

import com.example.hotel.models.request.ReviewRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.services.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/review")
public class ReviewController {

    @Autowired
    private IReviewService reviewService;

    @PostMapping(value="/createReview" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createReview(@RequestBody ReviewRequest request) {
        return new ResponseEntity<>(reviewService.createReview(request), HttpStatus.OK);
    }

    @PostMapping(value = "getReview", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getReview(@RequestBody ReviewRequest request) {
        return new ResponseEntity<>(reviewService.getReview(request), HttpStatus.OK);
    }
}
