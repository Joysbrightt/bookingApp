package com.Joysbrightt.BookingApp.data;

import com.Joysbrightt.BookingApp.model.AppointmentBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentBookingRepository extends JpaRepository<AppointmentBooking, Long> {

    Optional<AppointmentBooking> findById(Long appointmentBookingId);

}
