# 🚗 Car Parking System – Spring Boot Microservices

A modular Car Parking Booking System built with Spring Boot, Spring Cloud, Eureka, Config Server, API Gateway, Docker, and MySQL.

---

## 📦 Microservices Included

- ✅ **eureka-server** – Service registry for discovery
- ✅ **config-server** – Loads service configs from `config-repo/`
- ✅ **api-gateway** – Gateway that routes requests to services
- ✅ **user-management-service** – Handles user registration & retrieval
- ✅ **parking-management-service** – Manages slot booking, release, history
- ✅ **config-repo/** – Central `.yml` files for each service

---

## 🐳 Docker Services

`docker-compose.yml` launches:

- **MySQL** – port `3306`
- **Zipkin** – tracing dashboard at `http://localhost:9411`

```bash
docker-compose up -d
