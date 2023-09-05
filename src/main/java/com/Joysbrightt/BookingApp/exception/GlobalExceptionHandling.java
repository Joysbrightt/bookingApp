package com.Joysbrightt.BookingApp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException, WebRequest webRequest){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found" + userNotFoundException.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException userAlreadyExistException){
        return new ResponseEntity<>(userAlreadyExistException, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(BookingServiceNotFoundException.class)
    public ResponseEntity<Object> handleBookingServiceNotFoundException(BookingServiceNotFoundException bookingServiceNotFoundException){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BookingServiceAlreadyExistException.class)
    public ResponseEntity<Object> handleBookingServiceAlreadyExistException(BookingServiceAlreadyExistException bookingServiceAlreadyExistException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
