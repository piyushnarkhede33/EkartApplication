# 🛒 Ekart Application (Backend)

## 📌 Project Overview
**Ekart Application** is a backend-only e-commerce platform built using **Spring Boot microservices architecture**.  
It is designed with independently deployable services to ensure **scalability, fault tolerance, and maintainability**.

---

## 👨‍💻 Role
**Backend Developer**

---

## 🛠️ Tech Stack & Tools
- Java
- Spring Boot
- Spring Cloud
- REST APIs
- Microservices Architecture
- JPA / Hibernate
- MySQL
- Eureka (Service Discovery)
- Zuul (API Gateway)
- Resilience4j
- Logback (Centralized Logging)

---

## 🧩 System Architecture

The application follows a **distributed microservices architecture** with:
- API Gateway for routing and security
- Eureka for service discovery
- Independent services with separate databases
- Inter-service communication via REST and Feign Clients

### 📐 Architecture Diagram

```mermaid
flowchart LR
    Client -->|HTTP Requests| APIGateway[Zuul API Gateway]

    APIGateway --> Eureka[Eureka Service Registry]

    APIGateway --> ProductService[Product Service]
    APIGateway --> CustomerService[Customer Service]
    APIGateway --> OrderService[Order Service]
    APIGateway --> PaymentService[Payment Service]

    ProductService --> ProductDB[(Product DB)]
    CustomerService --> CustomerDB[(Customer DB)]
    OrderService --> OrderDB[(Order DB)]
    PaymentService --> PaymentDB[(Payment DB)]

    OrderService -->|Rest Template| ProductService
    OrderService -->|Rest Template| CustomerService
