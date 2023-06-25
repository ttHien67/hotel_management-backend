package com.example.hotel.controllers;


import com.example.hotel.models.request.BookingRoomRequest;
import com.example.hotel.models.request.RoomRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/room")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @PostMapping(value = "/getRoom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getRoom(@RequestBody RoomRequest request) {
        return new ResponseEntity<>(roomService.getRoom(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createRoom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createRoom(@RequestBody RoomRequest request) {
        return new ResponseEntity<>(roomService.createRoom(request), HttpStatus.OK);
    }

    @PutMapping(value = "/updateRoom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateRoom(@RequestBody RoomRequest request) {
        return new ResponseEntity<>(roomService.updateRoom(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteRoom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteRoom(@RequestBody RoomRequest request) {
        return new ResponseEntity<>(roomService.deleteRoom(request), HttpStatus.OK);
    }

    @PostMapping(value = "/checkRoom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> checkRoom(@RequestBody BookingRoomRequest request){
        return new ResponseEntity<>(roomService.checkRoom(request), HttpStatus.OK);
    }

}
