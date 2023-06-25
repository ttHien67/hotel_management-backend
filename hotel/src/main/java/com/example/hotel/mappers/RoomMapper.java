package com.example.hotel.mappers;


import com.example.hotel.models.request.BookingRoomRequest;
import com.example.hotel.models.request.RoomRequest;
import com.example.hotel.models.response.RoomResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomMapper {
    List<RoomResponse> getRoom(RoomRequest request);

    int countRoom(RoomRequest request);

    RoomResponse checkRoomCode(String code);

    RoomResponse create(RoomRequest request);

    RoomResponse update(RoomRequest request);

    RoomResponse delete(String id);

    List<RoomResponse> checkRoom(BookingRoomRequest request);


}
