package com.demo.HotelRoomBooking;

import com.demo.HotelRoomBooking.model.Booking;
import com.demo.HotelRoomBooking.model.Customer;
import com.demo.HotelRoomBooking.model.Room;
import com.demo.HotelRoomBooking.service.HotelBookingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelRoomBookingApplication implements CommandLineRunner {

    private HotelBookingService hotelBookingService;

    public HotelRoomBookingApplication (HotelBookingService hotelBookingService) {
        this.hotelBookingService = hotelBookingService;
    }

	public static void main(String[] args) {
        SpringApplication.run(HotelRoomBookingApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        Customer customer = Customer.builder()
                .customerId("C01")
                .customerName("Samuel")
                .phoneNumber("9342618420")
                .build();

        Room room = Room.builder()
                .roomId("R10")
                .roomNumber("5/19")
                .roomType("Single Room")
                .pricePerDay(1000)
                .build();

        Booking booking = Booking.builder()
                .bookingId("B01")
                .customer(customer)
                .room(room)
                .numberOfDays(4)
                .totalAmount(room.getPricePerDay() * 4)
                .build();

        hotelBookingService.displayBooking(booking);

    }
}
