package com.Joysbrightt.BookingApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="booking_service")
@Getter
@Setter
public class BookingService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "booking_service_id", nullable = false)
    private Long bookingServiceId;


    private String name;

    private String description;
}
