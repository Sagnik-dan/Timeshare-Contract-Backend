#Timeshare Contract Management System - Backend

A Spring Boot REST API for managing clients, hotels, and timeshare contracts for a travel and leisure company.

This application provides the backend services for a Timeshare Contract Management System, designed using a layered architecture following enterprise development practices.

---

## Features

### Client Management

* Create Client
* View All Clients
* View Client by ID
* Delete Client

### Hotel Management

* Create Hotel
* View All Hotels
* View Hotel by ID
* Delete Hotel

### Timeshare Contract Management

* Create Timeshare Contracts
* Associate Clients with Hotels
* View All Contracts
* View Contract by ID

### Exception Handling

* Custom Exceptions
* Global Exception Handler
* Proper HTTP Status Codes

---

## Tech Stack

* Java 21+
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL
* Lombok
* Maven

---

## Project Structure

```text
src
├── controller
├── dto
├── entity
├── exception
├── repository
├── service
│   └── impl
└── TimeshareManagementApplication
```

---

## Database

### Client

* clientId
* firstName
* lastName
* email
* phoneNumber
* address
* dateOfBirth

### Hotel

* hotelId
* hotelName
* city
* state
* country
* totalRooms
* active

### Timeshare Contract

* contractId
* contractNumber
* contractValue
* purchaseDate
* startDate
* endDate
* status
* client
* hotel

---

## API Endpoints

### Clients

| Method | Endpoint      |
| ------ | ------------- |
| POST   | /clients      |
| GET    | /clients      |
| GET    | /clients/{id} |
| DELETE | /clients/{id} |

### Hotels

| Method | Endpoint     |
| ------ | ------------ |
| POST   | /hotels      |
| GET    | /hotels      |
| GET    | /hotels/{id} |
| DELETE | /hotels/{id} |

### Contracts

| Method | Endpoint        |
| ------ | --------------- |
| POST   | /contracts      |
| GET    | /contracts      |
| GET    | /contracts/{id} |

---

## Running the Project

Clone the repository:

```bash
git clone https://github.com/Sagnik-dan/Timeshare-Contract-Backend.git
```

Configure MySQL in `application.yml`.

Run:

```bash
mvn spring-boot:run
```

Backend runs on:

```
http://localhost:8080
```

---

## Future Improvements

* JWT Authentication
* Role-Based Access
* Oracle OFSLL Integration
* Payment Module
* Swagger Documentation
* Docker Support
* AWS Deployment
* Unit & Integration Testing

---

## Author

**Sagnik Dandapat**

Java Backend Developer
