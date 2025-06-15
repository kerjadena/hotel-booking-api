package com.example.hotel_booking_api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
//gimana cara validasinya
import com.example.hotel_booking_api.model.Booking;
@Documented
@Constraint(validatedBy = CheckInBeforeCheckOutValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckInBeforeCheckOut {
   String message() default "Check-in date must be before check-out date";
   Class<?>[] groups() default {};
   Class<? extends Payload>[] payload() default {};
}