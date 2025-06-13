package com.example.hotel_booking_api.model;

import com.example.hotel_booking_api.validation.CheckInBeforeCheckOut;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@CheckInBeforeCheckOut
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long roomId;  // Sekarang hanya simpan ID room saja, tanpa relasi entity

    @NotBlank
    private String customerName;

    @Future
    private LocalDate checkIn;

    @Future
    private LocalDate checkOut;
}
