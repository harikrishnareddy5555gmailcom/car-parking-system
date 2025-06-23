package com.carparking.parkingmanagementservice.dto;

import lombok.Data;

@Data
public class BookingRequest {
    private Long userId;
    private Long slotId;
}
