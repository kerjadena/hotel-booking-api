//package com.example.hotel_booking_api.controller;
//
//import com.example.hotel_booking_api.model.Room;
//import com.example.hotel_booking_api.service.RoomService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/rooms")
//public class RoomController {
//
//    private final RoomService roomService;
//
//    public RoomController(RoomService roomService) {
//        this.roomService = roomService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Room> createRoom(@RequestBody @Validated Room room) {
//        Room createdRoom = roomService.addRoom(room);
//        return ResponseEntity.ok(createdRoom);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Room>> getAllRooms() {
//        List<Room> rooms = roomService.getAllRooms();
//        return ResponseEntity.ok(rooms);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
//        return roomService.getRoomById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//}
