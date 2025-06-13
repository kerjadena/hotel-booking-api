//package com.example.hotel_booking_api.repository;
//
//import com.example.hotel_booking_api.model.Booking;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public interface BookingRepository extends JpaRepository<Booking, Long> {
//    List<Booking> findByCheckInBetween(LocalDate start, LocalDate end);
//    List<Booking> findByRoomId(Long roomId);
//}
