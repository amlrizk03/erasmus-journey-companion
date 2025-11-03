# erasmus-journey-companion
Student: Aml Mohamed Rizk
Software Design Techniques course

Project Description

The Erasmus Journey Companion is a digital assistant designed to enhance the academic and social experience of Erasmus students studying abroad.
It integrates academic management, event organization, and communication tools into a single environment, helping students stay informed, connected, and organized.

Through this system, users can:

Create and update detailed personal and academic profiles.

Discover and join university or cultural activities.

Receive notifications about deadlines, events, or announcements.

Obtain personalized recommendations based on their interests, location, or university.

Connect with mentors, coordinators, and other Erasmus participants.

The project demonstrates the application of object-oriented design principles and software design patterns to build a modular, extensible, and maintainable system architecture.

System Objectives and Core Functionalities
1. User Management

Register and authenticate users.

Support multiple user roles: Student, Mentor, and Administrator.

Allow users to build and manage detailed personal and academic profiles.

2. Activity Management

Enable mentors and administrators to create and manage activities or events.

Allow students to view, register for, and subscribe to events.

Provide updates when activities are modified or new ones are published.

3. Recommendation System

Offer personalized recommendations for events or connections.

4. Notification System

Notify users automatically when relevant updates occur.

5. Document Management and Deadline Tracker

Allow students to upload, categorize, and store essential Erasmus-related documents such as learning agreements, housing forms, or identification copies.

Set reminders for important administrative or academic deadlines.

Integrate with the Notification System to send alerts prior to approaching deadlines.

System Modules
Module	Description	Key Design Patterns
User Module	Manages user creation, authentication, and profile building.	Factory, Builder
Activity Module	Handles creation and tracking of events and subscriptions.	Observer
Recommendation Module	Generates personalized recommendations.	Strategy
Notification Module	Sends notifications to users based on their subscriptions or deadlines.	Observer
Document Module	Manages document uploads and deadline reminders.	Builder, Observer
Core System	Coordinates communication between all modules.	—
Design Patterns and Justifications
1. Factory Method Pattern

Used for: Creating different user types such as Student, Mentor, and Administrator.

Problem Solved:
Without a factory, user creation would require repetitive conditional logic and manual configuration for each role.

Advantages:

Centralizes object creation logic.

Simplifies adding new user roles (e.g., Coordinator).

Improves maintainability and readability of code.

2. Builder Pattern

Used for: Constructing complex user profiles and managing document metadata.

Problem Solved:
Profiles and documents contain numerous optional attributes such as nationality, university, file type, and upload date.
A traditional constructor would be inflexible and difficult to maintain.

Advantages:

Builds objects in a clear, step-by-step manner.

Separates object construction from representation.

Enhances flexibility and scalability when new fields are added.


3. Strategy Pattern

Used for: Implementing different recommendation algorithms.

Problem Solved:
Different students prefer different recommendation criteria, such as by interest, location, or university.
Hardcoding all algorithms in a single class would make the system rigid and difficult to extend.

Advantages:

Enables switching between algorithms dynamically at runtime.

Promotes the Open/Closed Principle.

Simplifies testing and allows future expansion with minimal changes.


4. Observer Pattern

Used for: Handling notifications related to events and document deadlines.

Problem Solved:
Students should automatically receive updates when new activities are added or when deadlines approach, without manually checking the system.

Advantages:

Enables asynchronous, event-driven communication.

Decouples the subject (event or deadline) from the observers (students or mentors).

Allows new notification types to be added without modifying existing classes.





