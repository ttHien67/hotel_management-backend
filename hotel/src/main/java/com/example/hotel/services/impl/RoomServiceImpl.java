package com.example.hotel.services.impl;

import com.example.hotel.mappers.RoomMapper;
import com.example.hotel.models.request.RoomRequest;
import com.example.hotel.models.response.BaseResponse;
import com.example.hotel.models.response.RoomResponse;
import com.example.hotel.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private RoomMapper mapper;

    @Override
    public BaseResponse getRoom(RoomRequest request) {
        BaseResponse baseRespone = new BaseResponse();

        try {
            List<RoomResponse> response = mapper.getRoom(request);

            int countRoom = mapper.countRoom(request);

            if (response != null && countRoom > 0) {
                baseRespone.setData(response);
                baseRespone.setTotalRecord(countRoom);
                baseRespone.setErrorCode("0");
                baseRespone.setErrorDesc("Successfully");
            } else {
                baseRespone.setErrorCode("1");
                baseRespone.setErrorDesc("Failure");
            }

        } catch (Exception e) {
            baseRespone.setErrorCode("-1");
            baseRespone.setErrorDesc("Failure");
        }
        return baseRespone;
    }

    public BaseResponse createRoom(RoomRequest request) {
        BaseResponse baseResponse = new BaseResponse();

        try{
            RoomResponse checkRoomExistion = mapper.checkRoom(request.getCode());

            if(checkRoomExistion != null) {
                baseResponse = new BaseResponse("1", "Room has existed");
                return baseResponse;
            }

            RoomResponse result = mapper.create(request);
            if(result != null) {
                baseResponse = new BaseResponse(request, "0", "Create Successfully");
            }


        }catch (Exception e) {
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse updateRoom(RoomRequest request) {
        BaseResponse baseResponse = new BaseResponse();

        try{
            RoomResponse result = mapper.update(request);
            result.setCode(request.getCode());
            if(result != null) {
                baseResponse = new BaseResponse(request, "0", "Update Successfully");
            }


        }catch (Exception e) {
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

    public BaseResponse deleteRoom(RoomRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        try{
            RoomResponse result = mapper.delete(request.getId());
            if(result != null) {
                baseResponse = new BaseResponse("0", "Delete Successfully");
            }
        }catch (Exception e){
            baseResponse = new BaseResponse("1", "Failed");
            return baseResponse;
        }
        return baseResponse;
    }

}
