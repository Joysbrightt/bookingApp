package com.Joysbrightt.BookingApp.dto;


import lombok.Builder;

import lombok.Getter;

import lombok.Setter;

@Setter
@Getter
@Builder
public class LoginRequest {

    private String username;

    private String password;

//    public String getUsername() {
//        return username;
//    }
}
