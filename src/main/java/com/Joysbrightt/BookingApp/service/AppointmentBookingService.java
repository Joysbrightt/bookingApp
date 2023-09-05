package com.Joysbrightt.BookingApp.service;

import com.Joysbrightt.BookingApp.model.AppointmentBooking;

import java.util.Optional;

public interface AppointmentBookingService {

    AppointmentBooking createAppointment(AppointmentBooking appointmentBooking);

    AppointmentBooking updateAppointment(Long appointmentBookingId, AppointmentBooking booking);

    Optional<AppointmentBooking> findAppointmentById (Long appointmentBookingId);

    void deleteAppointment(Long appointmentBookingId);

}
