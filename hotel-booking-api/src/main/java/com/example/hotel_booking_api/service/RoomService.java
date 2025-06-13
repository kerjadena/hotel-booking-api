package com.example.hotel_booking_api.service;

import com.example.hotel_booking_api.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room addRoom(Room room) {
        if (roomRepository.existsByRoomNumber(room.getRoomNumber())) {
            throw new IllegalArgumentException("Room number already exists");
        }
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }
}

