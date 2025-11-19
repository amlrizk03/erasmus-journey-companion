# Milestone 3: Software Architecture Evaluation
---

## 1. Introduction

This document presents a detailed evaluation of three architectural styles for the Erasmus Journey Companion system. The system is designed to support Erasmus students in managing their study abroad experience by providing functionalities related to:

- User registration, authentication, and profile management
- Activity and event creation, discovery, and subscription
- Recommendation generation
- Automated notifications
- Document storage and deadline tracking

The purpose of this milestone is to compare different architectural approaches for implementing the system, analyze their suitability, and determine the most appropriate choice. The architectures evaluated are:

1. Monolithic Architecture
2. Microservices Architecture
3. Event-Driven Architecture

Each architecture is described in terms of structure, data flow, deployment characteristics, advantages, disadvantages, and alignment with the system’s requirements. The analysis concludes with a comparative evaluation and a final recommendation.

---

## 2. Architecture 1: Monolithic Architecture

### 2.1 Description
A monolithic architecture organizes the entire system as a single, unified application. All modules—User, Activity, Recommendation, Notification, and Document—run within the same process and share a single relational database.

### 2.2 Structural Overview
The monolithic system contains:

- A unified presentation layer
- A single business logic layer implementing all modules
- A centralized data access layer
- One shared database (e.g., PostgreSQL)

All internal module communication occurs through direct method calls.

#### How It Works:

**Example: Student Subscribes to Activity**

1. Student clicks "Subscribe" on "Photography Workshop" activity
2. Web interface sends request to Activity Module
3. Activity Module saves subscription to database
4. Activity Module calls Notification Module directly 
5. Notification Module sends confirmation email
6. All happens instantly in same application

**Data Flow:**
```
Student Browser → Web Interface → Activity Module → Database
                                 ↓
                          Notification Module → Email Service
```

### 2.3 Component Diagram
See: `monolithic-component.puml`

### 2.4 Deployment Diagram
See: `monolithic-deployment.puml`

### 2.5 Advantages

1. **Strong Data Consistency**
    - All data stored in a single database allows straightforward ACID-compliant transactions.

2. **Simplified Development and Debugging**
    - A single codebase makes development, testing, and debugging more manageable.

3. **Low Operational Complexity**
    - Deployment involves building and running a single executable artifact.

4. **Lower Cost**
    - Requires fewer servers, databases, and supporting services.

### 2.6 Disadvantages

1. **Limited Scalability**
    - Scaling requires duplicating the entire application rather than specific modules.

2. **Maintenance Difficulty as System Grows**
    - The codebase may become large, harder to understand, and challenging to modify.

3. **Tight Coupling**
    - All modules depend on each other, making it difficult to isolate failures or modify components independently.

4. **Single Point of Failure**
    - A fault in one module can disrupt the entire application.

---

## 3. Architecture 2: Microservices Architecture

### 3.1 Description
Microservices architecture decomposes the application into independent services. Each service manages its own domain logic and owns a dedicated database. Communication occurs via REST APIs or asynchronous messaging.

### 3.2 Structural Overview
Core services include:

- **User Service**
- **Activity Service**
- **Recommendation Service**
- **Notification Service**
- **Document Service**

Supporting infrastructure:

- API Gateway
- Message Broker
- Independent databases

### 3.3 Communication Model
- **Synchronous communication**: REST APIs
- **Asynchronous communication**: Message broker (for notifications, events, deadlines)


#### How It Works: 

**Example: Student Subscribes to Activity**

1. Student clicks "Subscribe" on activity
2. Browser sends request to **API Gateway**
3. API Gateway routes to **Activity Service**
4. Activity Service:
    - Calls **User Service** API to verify student exists
    - Saves subscription to its own database
    - Publishes "student_subscribed" event to **Message Broker**
5. **Notification Service** receives event from Message Broker
6. Notification Service:
    - Calls **User Service** API to get student's email
    - Sends confirmation email
7. **Recommendation Service** also receives event
    - Updates student's interest profile

**Data Flow:**
```
Student Browser → API Gateway → Activity Service → Activity DB
                                     ↓
                              Message Broker
                                ↙         ↘
                    Notification Service   Recommendation Service
                           ↓                        ↓
                       Email Sent            Update Interests
```

### 3.4 Component Diagram
See: `microservices-component.puml`

### 3.5 Deployment Diagram
See: `microservices-deployment.puml`

### 3.6 Advantages

1. **Independent Scaling**  
   Each service can scale based on its own load requirements. For example, Notification Service can scale without affecting User Service.

2. **Fault Isolation**  
   Issues in one service do not affect other running services.

3. **Technology Flexibility**  
   Services can be implemented using different technologies if needed.

4. **Improved Maintainability**  
   Smaller codebases reduce complexity and enhance long-term maintainability.

5. **Parallel Development**  
   Services can be built and deployed independently by different team members.

### 3.7 Disadvantages

1. **Operational Complexity**  
   Requires containerization, orchestration, monitoring, and distributed logging.

2. **Distributed Data Management**  
   Maintaining global consistency across multiple databases is challenging.

3. **Higher Latency**  
   Inter-service communication involves network overhead.

4. **Testing Complexity**  
   Requires integration testing across multiple services and communication channels.

---

## 4. Architecture 3: Event-Driven Architecture

### 4.1 Description
Event-Driven Architecture relies on asynchronous communication through events. Producers publish events to a broker, and consumers react independently. This architecture is suitable for systems with frequent state changes and real-time updates.

### 4.2 Structural Overview

- **Event Producers**: User Management, Activity Management, Document Management
- **Event Broker**: Kafka or RabbitMQ
- **Event Consumers**: Notification Handler, Recommendation Engine, Search Indexer
- **Event Store**: Historical record of system events
- **Read Models**: Optimized representations for querying

#### How It Works:

**Example: Student Subscribes to Activity**

1. Student clicks "Subscribe" on activity
2. Activity Management publishes `StudentSubscribedToActivity` event to broker
3. Event Broker distributes event to all subscribers:

   **Notification Handler:**
    - Receives event
    - Sends confirmation email to student

   **Recommendation Engine:**
    - Receives event
    - Updates: "This student likes photography workshops"
    - Adjusts future recommendations

   **Analytics:**
    - Receives event
    - Updates statistics: "Photography workshop popularity increased"

4. All happens asynchronously - Activity Management doesn't wait

**Key Difference:** Activity Management doesn't know who will react to the event. It just publishes and moves on.

**Data Flow:**
```
Student Subscribes
       ↓
Activity Management → Publishes Event → Event Broker
                                            ↙    ↓    ↘
                          Notification  Recommendation  Analytics
                                ↓
                          Send Email
```
### 4.3 Component Diagram
See: `event-driven-component.puml`

### 4.4 Deployment Diagram
See: `event-driven-deployment.puml`

### 4.5 Advantages

1. **High Scalability**  
   Producers and consumers can scale independently based on event volume.

2. **Decoupling of Components**  
   Producers do not need to know which services consume their events.

3. **Real-Time Behavior**  
   Suitable for live updates, notifications, and analytics.

4. **Auditability and Event Replay**  
   Event store allows system recovery and historical inspection.

### 4.6 Disadvantages

1. **Eventual Consistency**  
   Data does not update immediately across the system.

2. **Complex Debugging**  
   Tracing the event flow requires specialized tools.

3. **Higher Infrastructure Cost**  
   Requires maintaining an event broker and event store.

4. **Increased Complexity**  
   Asynchronous communication adds significant development complexity.

---

## 5. Comparative Evaluation

### 5.1 Comparison Table

| Criterion | Monolithic | Microservices | Event-Driven |
|----------|------------|---------------|--------------|
| Scalability | Low | High | Very High |
| Consistency | Strong | Moderate | Eventual |
| Operational Complexity | Low | Medium | High |
| Fault Isolation | Low | Medium | High |
| Maintainability | Low | High | High |
| Deployment Difficulty | Low | Medium | High |
| Flexibility | Low | High | High |
| Cost | Low | Medium | High |

---

## 6. Final Recommendation

Based on the analysis of all three architectural styles, **the Microservices Architecture is the most suitable choice for the Erasmus Journey Companion system**.

### Why Microservices Best Fit This Project

1. **Natural alignment with system modules**  
   The system already consists of clearly separated domains—User Management, Activities, Recommendations, Notifications, and Document Management.  
   These map directly to independent microservices without forcing artificial boundaries.

2. **Independent scalability where needed**  
   Different parts of the system will face different levels of traffic.  
   For example:
    - The Notification Service will experience peaks during deadline reminders.
    - The Activity Service will be busier at the beginning of each semester.  
      Microservices allow each of these services to scale independently, instead of scaling the whole system.

3. **Improved reliability and fault isolation**  
   A failure in one service (for example, the Document Service) does not bring down the entire platform.  
   This is important for a system that supports academic deadlines and time-sensitive events.

4. **Better maintainability and long-term flexibility**  
   Each service can be maintained, extended, and deployed independently.  
   New features (such as advanced recommendations or analytics) can be added as separate services without modifying the existing ones.

5. **Balanced complexity for this use case**  
   Microservices introduce some operational overhead compared to a monolithic architecture, but they are significantly less complex than a fully event-driven architecture while still offering the scalability and modularity the system needs.

### Final Verdict

**Microservices Architecture provides the best balance of scalability, reliability, maintainability, and future extensibility for the Erasmus Journey Companion system.**  
It fits the system’s modular structure and expected usage patterns without introducing unnecessary architectural complexity.

---

## 7. Conclusion

This architectural evaluation concludes that **Microservices Architecture** is the most suitable approach for the Erasmus Journey Companion system. Although Monolithic Architecture offers simplicity, it lacks the scalability and modularity needed for long-term evolution. Event-Driven Architecture provides strong decoupling and real-time processing but introduces operational and development complexity that exceeds the needs of this project. Microservices provide the optimal balance between flexibility, scalability, maintainability, and complexity.
