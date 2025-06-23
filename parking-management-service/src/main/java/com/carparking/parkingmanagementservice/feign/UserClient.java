package com.carparking.parkingmanagementservice.feign;

import com.carparking.parkingmanagementservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-management-service")
public interface UserClient {
    @GetMapping("/api/users/{userId}")
    User getUser(@PathVariable("userId") Long userId);
}