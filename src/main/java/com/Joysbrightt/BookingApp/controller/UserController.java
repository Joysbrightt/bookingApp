package com.Joysbrightt.BookingApp.controller;

import com.Joysbrightt.BookingApp.exception.UserAlreadyExistException;
import com.Joysbrightt.BookingApp.model.User;
import com.Joysbrightt.BookingApp.service.UserService;
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
    public ResponseEntity<?> createUser(@RequestBody User user) throws UserAlreadyExistException {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
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

    @PutMapping("/{updateUser}")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        user = userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @PutMapping("/{deleteUser}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
         userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
