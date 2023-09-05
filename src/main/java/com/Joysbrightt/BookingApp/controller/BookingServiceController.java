package com.Joysbrightt.BookingApp.controller;

import com.Joysbrightt.BookingApp.exception.BookingServiceNotFoundException;
import com.Joysbrightt.BookingApp.model.BookingService;
import com.Joysbrightt.BookingApp.service.TheBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/bookingService")
public class BookingServiceController {

    @Autowired
    private TheBookingService theBookingService;

    @PostMapping("/{createBookingService}")
    public ResponseEntity<BookingService> createBookingService(@RequestBody BookingService bookingService){
        BookingService theNewBookingService = theBookingService.createService(bookingService);
        return new ResponseEntity<>(theNewBookingService, HttpStatus.CREATED);
    }

    @PutMapping("/{updateTheBookingService}")
    public ResponseEntity<BookingService> updateTheBookingService(@PathVariable Long bookingServiceId, @RequestBody BookingService updatedBookingService){

        BookingService newlyUpdatedBookingService = theBookingService.updateService(bookingServiceId, updatedBookingService);
        return new ResponseEntity<>(newlyUpdatedBookingService, HttpStatus.OK);

    }

    @PutMapping("/{deleteBookingService}")
    public ResponseEntity<Void> deleteBookingService(@PathVariable Long bookingServiceId){
        theBookingService.deleteService(bookingServiceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{findBookingServiceId")
    public ResponseEntity<BookingService> findBookingServiceById(@PathVariable Long bookingServiceId){
        BookingService getBookingServiceId = theBookingService.findBookingServiceById(bookingServiceId).orElseThrow(() -> new BookingServiceNotFoundException("The booking service Id not found!"));

        return new  ResponseEntity<>(getBookingServiceId,HttpStatus.OK);
    }
}
