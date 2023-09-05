package com.Joysbrightt.BookingApp.service;

import com.Joysbrightt.BookingApp.model.AppointmentBooking;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentBookingServiceImpl implements AppointmentBookingService {
    @Override
    public AppointmentBooking createAppointment(AppointmentBooking appointmentBooking) {
        return null;
    }

    @Override
    public AppointmentBooking updateAppointment(Long appointmentBookingId, AppointmentBooking booking) {
        return null;
    }

    @Override
    public Optional<AppointmentBooking> findAppointmentById(Long appointmentBookingId) {
        return Optional.empty();
    }

    @Override
    public void deleteAppointment(Long appointmentBookingId) {

    }
}
