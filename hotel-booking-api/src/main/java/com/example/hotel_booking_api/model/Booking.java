package com.example.hotel_booking_api.model;

import com.example.hotel_booking_api.validation.CheckInBeforeCheckOut;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("room_id")
    private Long roomId;

    @NotBlank
    @JsonProperty("customer_name")
    private String customerName;

    @Future
    @JsonProperty("check_in")
    private LocalDate checkIn;

    @Future
    @JsonProperty("check_out")
    private LocalDate checkOut;
}
