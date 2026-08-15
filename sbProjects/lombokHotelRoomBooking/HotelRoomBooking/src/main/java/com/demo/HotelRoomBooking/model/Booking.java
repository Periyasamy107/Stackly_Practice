package com.demo.HotelRoomBooking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Booking {
    private String bookingId;
    private Customer customer;
    private Room room;
    private int numberOfDays;
    private double totalAmount;
}
