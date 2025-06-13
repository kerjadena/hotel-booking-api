package com.example.hotel_booking_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roomNumber;

    private String type;
    private Double price;

}

