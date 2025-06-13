package com.example.hotel_booking_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
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

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
}
