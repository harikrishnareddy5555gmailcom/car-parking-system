package com.carparking.parkingmanagementservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlot {
    @Id
    private Long slotId;
    private String location;
    private String slotNumber;
    private Boolean isAvailable;
    private Long bookedByUser;
    private LocalDateTime bookingTime;
}