# Milestone 5 - Message Queue & CI/CD Pipeline

This milestone extends the microservices system with:
- RabbitMQ for asynchronous communication
- CI/CD pipeline using GitHub Actions

---

## System Architecture

The system consists of three Spring Boot microservices:

### 1. User Service
- Port: 8081
- Responsibility: Manage users

Endpoints:
- POST /users
- GET /users
- GET /users/{id}

---

### 2. Activity Service
- Port: 8082
- Responsibility:
    - Manage activities
    - Consume messages from RabbitMQ

Endpoints:
- POST /activities
- GET /activities
- GET /activities/{id}

---

### 3. Participation Service
- Port: 8083
- Responsibility:
    - Manage user participation in activities
    - Publish events to RabbitMQ

Endpoints:
- POST /participations/join
- GET /participations/byUser/{userId}
- GET /participations/byActivity/{activityId}

---

## Message Queue Integration (RabbitMQ)

### Queue Used
- Queue name: `participation.joined.queue`

### How it Works
1. When a user joins an activity, the participation-service:
    - Saves participation data
    - Publishes a `ParticipationJoinedEvent` to RabbitMQ
2. The activity-service listens to this queue and consumes the event asynchronously.

### Benefits
- Loose coupling between services
- Better fault tolerance
- Improved scalability
- No direct REST dependency between services

### RabbitMQ Management UI
- URL: http://localhost:15672
- Username: guest
- Password: guest

You can verify message flow from:
Queues and Streams → `participation.joined.queue`

---

## Running the System with Docker

### Prerequisites
- Docker Desktop installed and running

### Start all services
From the project root directory (where docker-compose.yml exists):

```bash
docker compose up --build
