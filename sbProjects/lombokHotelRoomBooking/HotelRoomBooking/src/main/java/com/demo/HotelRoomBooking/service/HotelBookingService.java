package com.demo.HotelRoomBooking.service;

import com.demo.HotelRoomBooking.model.Booking;
import org.springframework.stereotype.Service;


@Service
public class HotelBookingService {

    public void displayBooking(Booking booking) {

        System.out.println();
        System.out.println("=================================");
        System.out.println("     CUSTOMER DETAILS : ");
        System.out.println("=================================");
        System.out.println("Customer ID : " + booking.getCustomer().getCustomerId());
        System.out.println("Customer Name : " + booking.getCustomer().getCustomerName());
        System.out.println("Phone Number : " + booking.getCustomer().getPhoneNumber());
        System.out.println();

        System.out.println();
        System.out.println("=================================");
        System.out.println("     ROOM DETAILS : ");
        System.out.println("=================================");
        System.out.println("Room ID : " + booking.getRoom().getRoomId());
        System.out.println("Room Number : " + booking.getRoom().getRoomNumber());
        System.out.println("Room Type : " + booking.getRoom().getRoomType());
        System.out.println("Price Per Day : " + booking.getRoom().getPricePerDay());
        System.out.println();

        System.out.println();
        System.out.println("=================================");
        System.out.println("     BOOKING DETAILS : ");
        System.out.println("=================================");
        System.out.println("Booking ID : " + booking.getBookingId());
        System.out.println("Customer : " + booking.getCustomer());
        System.out.println("Room : " + booking.getRoom());
        System.out.println("No Of Days : " + booking.getNumberOfDays());
        System.out.println("Total Amount : " + booking.getTotalAmount());
        System.out.println();

    }

}
