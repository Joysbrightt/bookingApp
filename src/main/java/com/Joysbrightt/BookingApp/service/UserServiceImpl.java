package com.Joysbrightt.BookingApp.service;

import com.Joysbrightt.BookingApp.data.UserRepository;
import com.Joysbrightt.BookingApp.dto.LoginRequest;
import com.Joysbrightt.BookingApp.exception.UserAlreadyExistException;
import com.Joysbrightt.BookingApp.exception.UserNotFoundException;
import com.Joysbrightt.BookingApp.model.User;
import jakarta.mail.AuthenticationFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public Optional<User> findByUsername(String username) {
       Optional<User> user = Optional.ofNullable(Optional.ofNullable(userRepository.findByUsername(username)).orElseThrow(() -> new UserNotFoundException("user not found")));

       return user;
    }

    @Override
    public User updateUser(User updatedUser) {
        Optional<User> existingUser = userRepository.findById(updatedUser.getId());

        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setUsername(updatedUser.getUsername());
            userToUpdate.setEmail(updatedUser.getEmail());
            userToUpdate.setPassword(updatedUser.getPassword());

//            if (updatedUser.getPassword())
            return userRepository.save(userToUpdate);
        }
        else {
            throw new UserNotFoundException("User not found with ID: " +updatedUser.getId());
        }
    }

    @Override
    public Optional<User> deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return Optional.empty();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) throws UserAlreadyExistException {
       if(userRepository.findByUsername(user.getUsername()) != null){
           throw new UserAlreadyExistException("User already exists");
       }
       User newUser = User.builder()
               .username(user.getUsername())
               .email(user.getEmail())
               .password(user.getPassword())
               .build();
       return userRepository.save(newUser);
    }

    @Override
    public PasswordAuthentication loginUser(LoginRequest loginRequest) throws AuthenticationFailedException {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        {
            throw new AuthenticationFailedException("Invalid password");
        }

        // If authentication is successful, return the PasswordAuthentication object
    }


    @Override
    public Optional<Optional<User>> findById(Long userId) {
        return Optional.ofNullable(userRepository.findById(userId));
    }
}
