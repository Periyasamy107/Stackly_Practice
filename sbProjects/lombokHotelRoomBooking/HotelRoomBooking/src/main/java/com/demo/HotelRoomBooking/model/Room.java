package com.demo.HotelRoomBooking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Room {
    private String roomId;
    private String roomNumber;
    private String roomType;
    private double pricePerDay;
}
