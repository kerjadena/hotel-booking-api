package com.example.hotel_booking_api.service;

import com.example.hotel_booking_api.model.Booking;
import com.example.hotel_booking_api.repository.BookingRepository;
import com.example.hotel_booking_api.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    public Booking createBooking(Booking booking) {
        validateRoomExists(booking.getRoomId());

        if (!isAvailable(booking.getRoomId(), booking.getCheckIn(), booking.getCheckOut())) {
            throw new IllegalStateException("Room not available for selected dates");
        }

        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking booking) {
        Booking existing = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        validateRoomExists(booking.getRoomId());

        if (!isAvailable(booking.getRoomId(), booking.getCheckIn(), booking.getCheckOut(), id)) {
            throw new IllegalStateException("Room not available for selected dates");
        }

        existing.setRoomId(booking.getRoomId());
        existing.setCustomerName(booking.getCustomerName());
        existing.setCheckIn(booking.getCheckIn());
        existing.setCheckOut(booking.getCheckOut());

        return bookingRepository.save(existing);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public boolean isAvailable(Long roomId, LocalDate checkIn, LocalDate checkOut) {
        return isAvailable(roomId, checkIn, checkOut, null);
    }

    private boolean isAvailable(Long roomId, LocalDate checkIn, LocalDate checkOut, Long excludeBookingId) {
        long count = bookingRepository.countByRoomIdAndDateOverlap(roomId, checkIn, checkOut);

        if (excludeBookingId != null) {
            Booking existing = bookingRepository.findById(excludeBookingId).orElse(null);
            if (existing != null && existing.getRoomId().equals(roomId)
                    && !(checkOut.isBefore(existing.getCheckIn()) || checkIn.isAfter(existing.getCheckOut()))) {
                count--; // exclude current booking from conflict
            }
        }
        return count == 0;
    }

    private void validateRoomExists(Long roomId) {
        if (!roomRepository.existsById(roomId)) {
            throw new IllegalArgumentException("Room not found");
        }
    }

    public List<Booking> getBookings(LocalDate startDate, LocalDate endDate) {
        return bookingRepository.findBookingsByDateRange(startDate, endDate);
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }
}
