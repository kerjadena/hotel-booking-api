//package com.example.hotel_booking_api.controller;
//
//import com.example.hotel_booking_api.model.Booking;
//import com.example.hotel_booking_api.service.BookingService;
//import jakarta.validation.Valid;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@RestController
//@RequestMapping("/bookings")
//public class BookingController {
//
//    private final BookingService bookingService;
//
//    public BookingController(BookingService bookingService) {
//        this.bookingService = bookingService;
//    }
//
//    @PostMapping
//    public Booking createBooking(@Valid @RequestBody Booking booking) {
//        return bookingService.save(booking);
//    }
//
//    @GetMapping
//    public List<Booking> getBookings(@RequestParam(required = false) LocalDate start,
//                                     @RequestParam(required = false) LocalDate end) {
//        if (start != null && end != null) {
//            return bookingService.getBookingsByDateRange(start, end);
//        }
//        return bookingService.getAllBookings();
//    }
//
//    @GetMapping("/{id}")
//    public Booking getBooking(@PathVariable Long id) {
//        return bookingService.getBooking(id);
//    }
//
//    @PutMapping("/{id}")
//    public Booking updateBooking(@PathVariable Long id, @Valid @RequestBody Booking updated) {
//        Booking existing = bookingService.getBooking(id);
//        if (existing == null) throw new RuntimeException("Booking not found");
//
//        existing.setCheckIn(updated.getCheckIn());
//        existing.setCheckOut(updated.getCheckOut());
//        return bookingService.save(existing);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteBooking(@PathVariable Long id) {
//        bookingService.deleteBooking(id);
//    }
//}
