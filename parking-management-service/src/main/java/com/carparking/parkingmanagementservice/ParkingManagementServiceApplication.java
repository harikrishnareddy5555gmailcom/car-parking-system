package com.carparking.parkingmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
//@EnableFeignClients
//public class ParkingManagementServiceApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(ParkingManagementServiceApplication.class, args);
//    }
//}
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ParkingManagementServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ParkingManagementServiceApplication.class, args);
    }
}