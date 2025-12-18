# Milestone 4 - Microservices Architecture (Spring Boot + Docker + Postman)

This project implements a simple microservices-based system using Spring Boot.
It demonstrates service separation, inter-service communication, Docker usage,
and API testing with Postman.

## Services Overview

The system consists of three independent microservices:

### 1) User Service
- Port: **8081**
- Responsibility: Manage users

Endpoints:
- `POST /users`
- `GET /users`
- `GET /users/{id}`

---

### 2) Activity Service
- Port: **8082**
- Responsibility: Manage activities

Endpoints:
- `POST /activities`
- `GET /activities`
- `GET /activities/{id}`

---

### 3) Participation Service
- Port: **8083**
- Responsibility: Manage user participation in activities
- Communicates with:
    - user-service
    - activity-service

Endpoints:
- `POST /participations/join`
- `GET /participations/byUser/{userId}`
- `GET /participations/byActivity/{activityId}`

---

## Inter-Service Communication

The participation-service communicates with other services using REST APIs.
Inside Docker, services communicate using **service names** instead of localhost:

- `http://user-service:8081`
- `http://activity-service:8082`

This configuration is defined in:
`participation-service/src/main/resources/application.properties`

---

## Database

Each microservice uses an **H2 in-memory database**.
Data is reset whenever the services are restarted.

---

## Running the System with Docker

### Prerequisites
- Docker Desktop installed and running

### Start all services
From the root directory (the folder that contains `docker-compose.yml`):

```bash
docker compose up --build
