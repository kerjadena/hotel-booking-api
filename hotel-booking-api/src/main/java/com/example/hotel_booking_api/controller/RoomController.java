package com.example.hotel_booking_api.controller;

import com.example.hotel_booking_api.model.Room;
import com.example.hotel_booking_api.service.BookingService;
import com.example.hotel_booking_api.service.RoomService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rooms")
public class RoomController {

   private final RoomService roomService;
   private final BookingService bookingService;

   public RoomController(RoomService roomService) {
       this.roomService = roomService;
       this.bookingService = null;
   }

   @PostMapping
   public ResponseEntity<Room> createRoom(@RequestBody @Validated Room room) {
       Room createdRoom = roomService.addRoom(room);
       return ResponseEntity.ok(createdRoom);
   }

   @GetMapping
   public ResponseEntity<List<Room>> getAllRooms() {
       List<Room> rooms = roomService.getAllRooms();
       return ResponseEntity.ok(rooms);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
       return roomService.getRoomById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
   }

   @GetMapping("/{id}/availability")
    public ResponseEntity<Map<String, Boolean>> checkAvailability(
        @PathVariable Long id,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut) {

    boolean isAvailable = bookingService.isAvailable(id, checkIn, checkOut);
    Map<String, Boolean> response = Map.of("available", isAvailable);
    return ResponseEntity.ok(response);
}

}
