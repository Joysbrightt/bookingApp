package com.Joysbrightt.BookingApp.service;

import com.Joysbrightt.BookingApp.model.BookingService;

import java.util.Optional;

public interface TheBookingService {

    BookingService createService(BookingService bookingService);

    BookingService updateService(Long serviceId, BookingService bookingService);


    void deleteService(Long bookingServiceId);

    Optional<BookingService> findBookingServiceById(Long bookingServiceId);

}
