//package com.example.hotel_booking_api.service;
//
//import com.example.hotel_booking_api.model.Booking;
//import com.example.hotel_booking_api.repository.BookingRepository;
//import jakarta.validation.constraints.Null;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Service
//public class BookingService {
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    public Booking save(Booking booking) {
//        if (booking.getCheckIn().isAfter(booking.getCheckOut())) {
//            throw new IllegalArgumentException("Check-in must be before check-out");
//        }
//        return bookingRepository.save(booking);
//    }
//
//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//
//    public List<Booking> getBookingsByDateRange(LocalDate start, LocalDate end) {
////        return bookingRepository.findByCheckInBetween(start, end);
//        return null;
//    }
//
//    public Booking getBooking(Long id) {
//        return bookingRepository.findById(id).orElse(null);
//    }
//
//    public void deleteBooking(Long id) {
//        bookingRepository.deleteById(id);
//    }
//}
