package com.carparking.usermanagementservice.repository;

import com.carparking.usermanagementservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}