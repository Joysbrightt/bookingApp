package com.Joysbrightt.BookingApp.service;

import com.Joysbrightt.BookingApp.dto.LoginRequest;
import com.Joysbrightt.BookingApp.exception.UserAlreadyExistException;
import com.Joysbrightt.BookingApp.model.User;
import jakarta.mail.AuthenticationFailedException;

import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    User updateUser(User updatedUser);

    Optional<User> deleteUser(Long userId);

    List<User> getAllUsers();

    User createUser(User user) throws UserAlreadyExistException;

    PasswordAuthentication loginUser(LoginRequest loginRequest) throws AuthenticationFailedException;

    Optional<Optional<User>> findById(Long userId);
}
