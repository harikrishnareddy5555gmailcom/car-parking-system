package com.carparking.parkingmanagementservice.controller;

import com.carparking.parkingmanagementservice.dto.BookingRequest;
import com.carparking.parkingmanagementservice.entity.ParkingSlot;
import com.carparking.parkingmanagementservice.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping("/available")
    public List<ParkingSlot> getAvailableSlots() {
        return parkingService.getAvailableSlots();
    }

    // ✅ Updated bookSlot() method with error handling and response JSON
//    @PostMapping("/book/{slotId}/{userId}")
//    public ResponseEntity<?> bookSlot(@PathVariable Long slotId, @PathVariable Long userId) {
//        try {
//            ParkingSlot slot = parkingService.bookSlot(slotId, userId);
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("message", "Slot booked successfully");
//            response.put("slot", slot);
//
//            return ResponseEntity.ok(response);
//
//        } catch (Exception e) {
//            e.printStackTrace(); // Logs the full exception to console
//
//            Map<String, Object> errorResponse = new HashMap<>();
//            errorResponse.put("message", "Booking failed");
//            errorResponse.put("error", e.getMessage());
//
//            return ResponseEntity.status(500).body(errorResponse);
//        }
//    }
    @PostMapping("/book")
    public ResponseEntity<?> bookSlot(@RequestBody BookingRequest request) {
        try {
            ParkingSlot slot = parkingService.bookSlot(request.getSlotId(), request.getUserId());

            return ResponseEntity.ok(Map.of(
                    "message", "Slot booked successfully",
                    "slot", slot
            ));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of(
                    "message", "Booking failed",
                    "error", e.getMessage()
            ));
        }
    }


    @PostMapping("/release/{slotId}")
    public ParkingSlot releaseSlot(@PathVariable Long slotId) {
        return parkingService.releaseSlot(slotId);
    }

    @GetMapping("/history/{userId}")
    public List<ParkingSlot> getHistoryByUser(@PathVariable Long userId) {
        return parkingService.getHistoryByUser(userId);
    }
}
