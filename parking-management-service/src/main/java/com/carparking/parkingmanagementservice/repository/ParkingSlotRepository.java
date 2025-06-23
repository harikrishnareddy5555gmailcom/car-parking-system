package com.carparking.parkingmanagementservice.repository;

import com.carparking.parkingmanagementservice.entity.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;
import java.util.List;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {
    List<ParkingSlot> findByIsAvailableTrue();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    ParkingSlot findWithLockingBySlotId(Long slotId);

    List<ParkingSlot> findByBookedByUser(Long userId);
}