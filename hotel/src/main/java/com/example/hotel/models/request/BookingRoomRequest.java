package com.example.hotel.models.request;

import java.sql.Timestamp;

public class BookingRoomRequest {
    private String checkIn;
    private String checkOut;
    private int quantityGuest;
    private int quantityRoom;

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getQuantityGuest() {
        return quantityGuest;
    }

    public void setQuantityGuest(int quantityGuest) {
        this.quantityGuest = quantityGuest;
    }

    public int getQuantityRoom() {
        return quantityRoom;
    }

    public void setQuantityRoom(int quantityRoom) {
        this.quantityRoom = quantityRoom;
    }
}
