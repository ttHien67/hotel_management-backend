package com.example.hotel.services;


import com.example.hotel.models.request.RoomRequest;
import com.example.hotel.models.response.BaseResponse;

public interface IRoomService {

    public BaseResponse getRoom(RoomRequest request);

    public BaseResponse createRoom(RoomRequest request);

    public BaseResponse updateRoom(RoomRequest request);

    public BaseResponse deleteRoom(RoomRequest request);

}
