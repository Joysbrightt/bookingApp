package com.Joysbrightt.BookingApp.service;

import com.Joysbrightt.BookingApp.data.BookingServiceRepository;
import com.Joysbrightt.BookingApp.exception.BookingServiceAlreadyExistException;
import com.Joysbrightt.BookingApp.exception.BookingServiceNotFoundException;
import com.Joysbrightt.BookingApp.model.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TheBookingServiceImpl implements TheBookingService {

    @Autowired
    private BookingServiceRepository bookingServiceRepository;


    @Override
    public BookingService createService(BookingService bookingService) {
        BookingService savedBookingService = bookingServiceRepository.findBookingServiceById(bookingService.getBookingServiceId())
                .orElseThrow( () -> new BookingServiceAlreadyExistException("booking service with the id number is not found!"));

        savedBookingService.setName(bookingService.getName());
        savedBookingService.setDescription(bookingService.getDescription());
        return bookingServiceRepository.save(savedBookingService);
    }

    @Override
    public BookingService updateService(Long bookingServiceId, BookingService bookingService) {

        BookingService existingService = bookingServiceRepository.findById(bookingServiceId).orElseThrow(() -> new BookingServiceNotFoundException("Booking service with this " +bookingServiceId +" is not found!"));
        existingService.setName(bookingService.getName());
        existingService.setDescription(bookingService.getDescription());

        return bookingServiceRepository.save(existingService);
    }

    @Override
    public void deleteService(Long bookingServiceId) {

        bookingServiceRepository.deleteById(bookingServiceId);
    }

    @Override
    public Optional<BookingService> findBookingServiceById(Long bookingServiceId) {
        return bookingServiceRepository.findById(bookingServiceId);
    }
}
