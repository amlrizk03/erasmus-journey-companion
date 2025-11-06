## Milestone 2: UML Design & Implementation

### UML Diagrams

All diagrams are created using PlantUML and located in the `diagrams/` folder.

#### Class Diagram
- **File:** `diagrams/class-diagram.puml`
- **Description:** Complete system architecture showing all four design patterns integrated together
- **Includes:** All classes, relationships, attributes, and methods with pattern notes

#### Sequence Diagrams

**Sequence Diagram 1** - User Registration and Activity Subscription
- **File:** `diagrams/sequence-diagram-1.puml`
- **Shows:** Factory pattern (user creation), Builder pattern (profile building), Observer pattern (notifications)

**Sequence Diagram 2** - Recommendations and Document Deadlines
- **File:** `diagrams/sequence-diagram-2.puml`
- **Shows:** Strategy pattern (recommendation algorithms), Builder pattern (documents), Observer pattern (deadline alerts)



### Implementation

#### What Was Implemented
- Factory Method for creating different user types
- Builder pattern for UserProfile and Document construction
- Observer pattern for activity and deadline notifications
- Strategy pattern for switching recommendation algorithms

