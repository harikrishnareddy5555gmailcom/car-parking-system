package com.carparking.parkingmanagementservice.service;

import com.carparking.parkingmanagementservice.entity.ParkingSlot;
import com.carparking.parkingmanagementservice.feign.UserClient;
import com.carparking.parkingmanagementservice.model.User;
import com.carparking.parkingmanagementservice.repository.ParkingSlotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParkingService {

    @Autowired
    private ParkingSlotRepository repository;

    @Autowired
    private UserClient userClient;

    public List<ParkingSlot> getAvailableSlots() {
        return repository.findByIsAvailableTrue();
    }

    @Transactional  // ✅ REQUIRED for pessimistic locking to work!
    public ParkingSlot bookSlot(Long slotId, Long userId) {
        User user = userClient.getUser(userId); // Validate user exists
        if (user == null) throw new RuntimeException("User not found");

        ParkingSlot slot = repository.findWithLockingBySlotId(slotId);
        if (slot != null && slot.getIsAvailable()) {
            slot.setIsAvailable(false);
            slot.setBookedByUser(userId);
            slot.setBookingTime(LocalDateTime.now());
            return repository.save(slot);
        }

        throw new RuntimeException("Slot not available or not found");
    }

    public ParkingSlot releaseSlot(Long slotId) {
        ParkingSlot slot = repository.findById(slotId).orElse(null);
        if (slot != null && !slot.getIsAvailable()) {
            slot.setIsAvailable(true);
            slot.setBookedByUser(null);
            slot.setBookingTime(null);
            return repository.save(slot);
        }
        return null;
    }

    public List<ParkingSlot> getHistoryByUser(Long userId) {
        return repository.findByBookedByUser(userId);
    }
}
