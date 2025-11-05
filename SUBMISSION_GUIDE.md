# Milestone 2 Submission Guide

## What to Submit

Create a branch named `2-design-and-implementation` with all the milestone 2 deliverables.

## Step-by-Step Submission Process

### 1. Create a New Branch
```bash
git checkout -b 2-design-and-implementation
```

### 2. Add All Files
```bash
git add src/
git add diagrams/
git add README_MILESTONE2.md
git add compile-and-run.sh
git add .gitignore
git add SUBMISSION_GUIDE.md
```

### 3. Commit Changes
```bash
git commit -m "Milestone 2: Complete design and implementation with UML diagrams and Java code"
```

### 4. Push to GitHub
```bash
git push origin 2-design-and-implementation
```

### 5. Submit on Platform
1. Go to https://sdt.rusudinu.ro/
2. Submit the repository link: `https://github.com/amlrizk03/erasmus-journey-companion`
3. Ensure the branch `2-design-and-implementation` is visible

## Files Included in Milestone 2

### Source Code (Java Implementation)
```
src/main/java/com/erasmus/
├── user/
│   ├── User.java
│   ├── Student.java
│   ├── Mentor.java
│   ├── Administrator.java
│   ├── UserFactory.java (Factory Pattern)
│   └── UserProfile.java (Builder Pattern)
├── activity/
│   └── Activity.java (Observer Pattern)
├── notification/
│   ├── Observer.java
│   └── Subject.java
├── recommendation/ (Strategy Pattern)
│   ├── RecommendationStrategy.java
│   ├── InterestBasedRecommendation.java
│   ├── LocationBasedRecommendation.java
│   ├── UniversityBasedRecommendation.java
│   └── RecommendationEngine.java
├── document/
│   ├── Document.java (Builder Pattern)
│   └── DeadlineNotifier.java (Observer Pattern)
└── main/
    └── ErasmusJourneyDemo.java
```

### UML Diagrams
```
diagrams/
├── class-diagram.puml (Comprehensive class diagram with all 4 patterns)
├── sequence-diagram-1.puml (User registration & subscription)
├── sequence-diagram-2.puml (Recommendations & notifications)
└── HOW_TO_VIEW_DIAGRAMS.md
```

### Documentation
- `README_MILESTONE2.md` - Complete documentation for Milestone 2
- `compile-and-run.sh` - Easy compilation and execution script
- `SUBMISSION_GUIDE.md` - This file

## Verification Checklist

Before submitting, verify:

- [ ] Code compiles without errors
  ```bash
  ./compile-and-run.sh
  ```

- [ ] All 4 design patterns are implemented:
  - [ ] Factory Method Pattern (UserFactory)
  - [ ] Builder Pattern (UserProfile, Document)
  - [ ] Observer Pattern (Activity, DeadlineNotifier)
  - [ ] Strategy Pattern (RecommendationEngine with 3 strategies)

- [ ] UML diagrams are complete:
  - [ ] Class diagram shows all classes and patterns
  - [ ] Sequence diagram 1 shows user registration flow
  - [ ] Sequence diagram 2 shows recommendations flow

- [ ] README_MILESTONE2.md includes:
  - [ ] Project structure
  - [ ] Compilation instructions
  - [ ] Pattern explanations
  - [ ] Diagram viewing instructions

- [ ] All files are committed to the branch
- [ ] Branch is pushed to GitHub
- [ ] Repository is public

## Presentation Preparation

For the project meeting, be prepared to explain:

1. **Factory Method Pattern**
   - How it creates different user types
   - Why it's better than using constructors directly

2. **Builder Pattern**
   - How it constructs UserProfile and Document
   - Benefits over telescoping constructors

3. **Observer Pattern**
   - How Activity notifies subscribers
   - How DeadlineNotifier works
   - Demonstration of automatic notifications

4. **Strategy Pattern**
   - How recommendation algorithms are interchangeable
   - Demonstration of switching strategies at runtime

5. **Pattern Interactions**
   - How all patterns work together in the system

## Demo Script for Presentation

Run the demo and explain each section:

```bash
./compile-and-run.sh
```

Point out:
1. Users being created by Factory
2. Profiles being built step-by-step
3. Observers receiving notifications
4. Different recommendation strategies producing different results

## Common Questions & Answers

**Q: Why use Factory instead of constructors?**  
A: Centralizes creation logic, makes it easy to add new user types, and follows the Open/Closed Principle.

**Q: How does Observer pattern help?**  
A: Decouples the notification system - activities don't need to know who's subscribed or how to notify them.

**Q: Can we add more strategies?**  
A: Yes! Just create a new class implementing RecommendationStrategy - no need to modify existing code.

**Q: Why are patterns integrated, not separate?**  
A: Real systems use multiple patterns together. Our design shows how they complement each other.

## Grade 10 Requirements - Verification

✅ **Detailed and well-structured UML class diagram**
- All classes shown with proper relationships
- All 4 patterns clearly annotated
- Single comprehensive diagram

✅ **Two comprehensive sequence diagrams**
- Diagram 1: User creation, profile building, activity subscription
- Diagram 2: Recommendations with strategy switching, deadline notifications
- Both show detailed interaction flows

✅ **Well-structured Java implementation**
- Clean package structure
- All patterns correctly implemented
- Code follows OOP principles

✅ **All four patterns demonstrated**
- Factory Method: UserFactory creates 3 user types
- Builder: UserProfile and Document construction
- Observer: Activity and DeadlineNotifier
- Strategy: 3 recommendation algorithms

✅ **Patterns interact with each other**
- Factory creates users who are Observers
- Builder creates profiles used by Strategy
- All patterns work together in demo

Good luck with your submission! 🎓
