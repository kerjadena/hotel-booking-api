package com.example.hotel_booking_api.repository;

import com.example.hotel_booking_api.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("""
        SELECT COUNT(b) FROM Booking b
        WHERE b.roomId = :roomId
        AND (:checkIn < b.checkOut AND :checkOut > b.checkIn)
        """)
    long countByRoomIdAndDateOverlap(
            @Param("roomId") Long roomId,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut
    );

    @Query("""
        SELECT b FROM Booking b
        WHERE (:startDate IS NULL OR b.checkIn >= :startDate)
          AND (:endDate IS NULL OR b.checkOut <= :endDate)
    """)
    List<Booking> findBookingsByDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
