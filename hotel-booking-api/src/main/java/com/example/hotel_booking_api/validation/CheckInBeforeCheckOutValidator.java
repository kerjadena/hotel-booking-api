// validation/CheckInBeforeCheckOutValidator.java
package com.example.hotel_booking_api.validation;

import com.example.hotel_booking_api.model.Booking;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckInBeforeCheckOutValidator implements ConstraintValidator<CheckInBeforeCheckOut, Booking> {
    @Override
    public boolean isValid(Booking booking, ConstraintValidatorContext context) {
        if (booking.getCheckIn() == null || booking.getCheckOut() == null) {
            return true; // Let @Future handle nulls
        }
        return booking.getCheckIn().isBefore(booking.getCheckOut());
    }
}