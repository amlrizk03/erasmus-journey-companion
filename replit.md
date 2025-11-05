# Erasmus Journey Companion

## Overview

The Erasmus Journey Companion is an educational Java application designed to help students manage their Erasmus exchange program experience. The system demonstrates various design patterns including Factory Method, Builder, Observer, and Strategy patterns. It provides functionality for user management, activity tracking, notifications, document handling, and personalized recommendations for Erasmus students.

## User Preferences

Preferred communication style: Simple, everyday language.

## System Architecture

### Core Design Patterns

**Factory Method Pattern (User Creation)**
- Problem: Need flexible creation of different user types (Student, Mentor, Administrator) without coupling code to specific classes
- Solution: UserFactory class provides centralized user instantiation with type-based creation logic
- Benefits: Enables easy extension of new user types, centralizes creation logic, improves maintainability

**Builder Pattern (Complex Object Construction)**
- Problem: UserProfile and Document objects have many optional parameters making constructor overloading unwieldy
- Solution: Builder classes provide fluent interfaces for step-by-step object construction
- Benefits: Improves code readability, supports optional parameters elegantly, makes object construction more flexible

**Observer Pattern (Event Notifications)**
- Problem: Multiple components need to react to changes in Activity and Document states without tight coupling
- Solution: Subject/Observer interfaces allow objects to subscribe to events and receive notifications automatically
- Benefits: Loose coupling between components, easy to add new observers, supports publish-subscribe model

**Strategy Pattern (Recommendation Algorithms)**
- Problem: Different recommendation approaches (interest-based, location-based, university-based) need to be interchangeable at runtime
- Solution: RecommendationStrategy interface with multiple implementations allows algorithm selection without changing client code
- Benefits: Runtime algorithm switching, easy to add new recommendation strategies, adheres to Open/Closed Principle

### Application Structure

**Package Organization**
- `user/` - User hierarchy and creation logic (Factory + Builder)
- `activity/` - Activity management (Observer subject)
- `notification/` - Notification framework (Observer interfaces)
- `recommendation/` - Recommendation engine (Strategy implementations)
- `document/` - Document management with deadline tracking (Builder + Observer)
- `main/` - Application entry point and demonstrations

**Object Model**
- User hierarchy: Base User class with Student, Mentor, and Administrator specializations
- Activity model: Trackable events that notify observers of changes
- Document model: Complex objects built with builder pattern and deadline notifications
- Recommendation engine: Context-aware recommendation generation using pluggable strategies

### Language and Runtime

**Java-based Implementation**
- Pure Java SE application demonstrating object-oriented design principles
- No external frameworks or dependencies
- Compilation via standard javac compiler
- Execution through standard java runtime

## Recent Changes

### Milestone 2 - Design and Implementation (November 2025)
- ✅ Implemented all 4 design patterns in Java
- ✅ Created comprehensive UML class diagram with all patterns integrated
- ✅ Created 2 detailed UML sequence diagrams
- ✅ Demonstrated all patterns working together in proof-of-concept
- ✅ Code verified and tested successfully

## External Dependencies

### Build and Development Tools

**Java Development Kit (JDK)**
- Required for compilation and execution
- Standard Java SE APIs used throughout
- Java 11+ recommended

**PlantUML (Diagram Documentation)**
- UML diagrams stored in `.puml` format under `diagrams/` directory
- Viewable through online editors (plantuml.com, planttext.com) or IDE plugins
- No runtime dependency - documentation only

**Git Version Control**
- Repository hosted on GitHub at: https://github.com/amlrizk03/erasmus-journey-companion
- Branch-based workflow for milestone submissions
- Milestone 1: `1-project-description` branch
- Milestone 2: `2-design-and-implementation` branch (current)
- No Git integration in application code

### No External Runtime Dependencies

The application is designed as a standalone Java application with:
- No database connections
- No web frameworks
- No third-party libraries
- No REST APIs or external service integrations
- No authentication services

All functionality is self-contained within the Java codebase for educational demonstration purposes.