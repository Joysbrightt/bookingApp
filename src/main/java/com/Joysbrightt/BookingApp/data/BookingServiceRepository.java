package com.Joysbrightt.BookingApp.data;

import com.Joysbrightt.BookingApp.model.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingServiceRepository extends JpaRepository<BookingService, Long> {

    Optional<BookingService> findBookingServiceById(Long bookingServiceId);
}
