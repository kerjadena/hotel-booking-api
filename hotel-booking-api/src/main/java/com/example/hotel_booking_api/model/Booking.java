package com.example.hotel_booking_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @Future(message = "Check-in date must be in the future")
    private LocalDate checkIn;

    @Future(message = "Check-out date must be in the future")
    private LocalDate checkOut;

    @Column(name = "room_id")
    private Room roomId;
}