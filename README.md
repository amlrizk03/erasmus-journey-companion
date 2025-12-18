# Milestone 5 – Message Queue Integration & CI/CD

This milestone extends the existing microservices system by adding:
- **RabbitMQ** for asynchronous communication between services
- A **CI/CD pipeline** using GitHub Actions to automatically build, test, and deploy the system

---

## Message Queue Integration (RabbitMQ)

### Overview
RabbitMQ is used to enable **asynchronous, event-driven communication** between microservices.
This reduces tight coupling and improves scalability and fault tolerance.

---

### Queue Configuration
- **Queue Name:** `participation.joined.queue`

---

### How It Works
1. When a user joins an activity, the **participation-service**:
    - Saves participation data in its database
    - Publishes a `ParticipationJoinedEvent` to RabbitMQ
2. The **activity-service** listens to the queue and consumes the event asynchronously.
3. The activity service processes the event without making any direct REST calls to the participation service.

---

### Services Involved

#### Participation Service (Producer)
- Publishes messages to RabbitMQ when a user joins an activity
- Responsible for emitting domain events

#### Activity Service (Consumer)
- Listens to RabbitMQ queue
- Consumes and processes `ParticipationJoinedEvent`

---

### Benefits of Using RabbitMQ
- Loose coupling between services
- Improved fault tolerance (services can work independently)
- Better scalability
- Non-blocking, asynchronous communication
- Reduced dependency on synchronous REST calls

---

### RabbitMQ Management UI
You can monitor the message queue using RabbitMQ’s web interface:

- **URL:** http://localhost:15672
- **Username:** `guest`
- **Password:** `guest`

To verify message flow:
Queues and Streams → participation.joined.queue


---

## CI/CD Pipeline (GitHub Actions)

### Overview
A CI/CD pipeline is implemented using **GitHub Actions** to automate the build, test, and deployment process.

---

### Pipeline Configuration
The pipeline is defined in:
.github/workflows/ci.yml


---

### Pipeline Workflow
On every push to the **Milestone 5 branch**:

1. The repository is checked out
2. Java 17 is set up
3. All microservices are built using Maven
4. Unit tests are executed
5. Docker images are built for all services
6. The system is deployed using Docker Compose

---

### How to Observe the Pipeline
1. Open the GitHub repository
2. Navigate to the **Actions** tab
3. Select the workflow:
   **Milestone 5: add CI/CD pipeline (GitHub Actions)**
4. Review logs for build, test, and Docker steps

---

### Benefits of CI/CD
- Automated verification of code changes
- Early detection of build or integration issues
- Consistent and repeatable deployment process
- Improved reliability of the microservices system

---

## Running the System Locally

### Prerequisites
- Docker Desktop installed and running

### Start the system
From the project root directory:
```bash
docker compose up --build
