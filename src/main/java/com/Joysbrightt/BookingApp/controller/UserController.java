package com.Joysbrightt.BookingApp.controller;

import com.Joysbrightt.BookingApp.exception.UserAlreadyExistException;
import com.Joysbrightt.BookingApp.exception.UserNotFoundException;
import com.Joysbrightt.BookingApp.model.User;
import com.Joysbrightt.BookingApp.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/{user}")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{createUser}")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (UserAlreadyExistException e) {
            // Handle the case where the user already exists.
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        } catch (ValidationException e) {
            // Handle validation errors (if any).
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // Handle other unexpected errors.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }


    @GetMapping("/{userId}")
    public ResponseEntity<?> findByUserId(@PathVariable Long userId){
        Optional<Optional<User>> user = userService.findById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userId);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> findUserByUsername(@PathVariable String username){
        Optional<User> user = userService.findByUsername(username);
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    public ResponseEntity<?> updateUser(@RequestBody @Valid User user) {
        try {
            user = userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
        } catch (UserNotFoundException e) {
            // Handle the case where the user to be updated was not found.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (ValidationException e) {
            // Handle validation errors (if any).
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // Handle other unexpected errors.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }


    @PutMapping("/{deleteUser}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
         userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
