package com.erasmus.main;

import com.erasmus.user.*;
import com.erasmus.activity.Activity;
import com.erasmus.recommendation.*;
import com.erasmus.document.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ErasmusJourneyDemo {
    
    public static void main(String[] args) {
        System.out.println("=== ERASMUS JOURNEY COMPANION - DESIGN PATTERNS DEMO ===\n");
        
        System.out.println("--- 1. FACTORY METHOD PATTERN: Creating Users ---");
        User student1 = UserFactory.createUser("STUDENT", "S001", "Maria Garcia", "maria@email.com");
        User student2 = UserFactory.createUser("STUDENT", "S002", "Ahmed Hassan", "ahmed@email.com");
        User mentor = UserFactory.createUser("MENTOR", "M001", "Prof. Schmidt", "schmidt@uni.edu");
        User admin = UserFactory.createUser("ADMIN", "A001", "Lisa Chen", "lisa.chen@admin.eu");
        
        System.out.println("Created: " + student1.getName() + " - " + student1.getRole());
        System.out.println("Created: " + student2.getName() + " - " + student2.getRole());
        System.out.println("Created: " + mentor.getName() + " - " + mentor.getRole());
        System.out.println("Created: " + admin.getName() + " - " + admin.getRole());
        
        System.out.println("\n--- 2. BUILDER PATTERN: Building User Profiles ---");
        UserProfile mariaProfile = new UserProfile.UserProfileBuilder()
                .bio("Computer Science student from Spain")
                .nationality("Spanish")
                .university("Politehnica Bucharest")
                .fieldOfStudy("Computer Science")
                .addInterest("Technology")
                .addInterest("Culture")
                .addInterest("Sports")
                .location("Bucharest")
                .phoneNumber("+40-123-456-789")
                .emergencyContact("+34-987-654-321")
                .build();
        
        student1.setProfile(mariaProfile);
        System.out.println("Profile created for " + student1.getName() + ":");
        System.out.println(mariaProfile);
        
        UserProfile ahmedProfile = new UserProfile.UserProfileBuilder()
                .bio("Engineering student from Egypt")
                .nationality("Egyptian")
                .university("Politehnica Bucharest")
                .fieldOfStudy("Mechanical Engineering")
                .addInterest("Culture")
                .addInterest("Music")
                .location("Bucharest")
                .build();
        
        student2.setProfile(ahmedProfile);
        System.out.println("\nProfile created for " + student2.getName());
        
        System.out.println("\n--- 3. BUILDER PATTERN: Creating Documents ---");
        Document learningAgreement = new Document.DocumentBuilder("DOC001", "S001", "Learning_Agreement.pdf")
                .fileType("PDF")
                .category("Academic")
                .deadline(LocalDate.now().plusDays(5))
                .description("Signed learning agreement for Spring 2025")
                .filePath("/documents/learning_agreement.pdf")
                .build();
        
        System.out.println("Document created: " + learningAgreement);
        
        System.out.println("\n--- 4. OBSERVER PATTERN: Activity Notifications ---");
        Activity culturalNight = new Activity(
                "ACT001",
                "International Cultural Night",
                "Experience cultures from around the world with music, food, and performances",
                "Culture",
                "Bucharest",
                "2025-11-15",
                "Politehnica Bucharest",
                100
        );
        
        Activity techWorkshop = new Activity(
                "ACT002",
                "Java Programming Workshop",
                "Advanced Java design patterns and best practices",
                "Technology",
                "Bucharest",
                "2025-11-20",
                "CS Department",
                30
        );
        
        culturalNight.registerObserver(student1);
        culturalNight.registerObserver(student2);
        culturalNight.registerObserver(mentor);
        
        techWorkshop.registerObserver(student1);
        
        System.out.println("\nUpdating activity information:");
        culturalNight.setDate("2025-11-16");
        
        System.out.println("\n--- 5. OBSERVER PATTERN: Deadline Notifications ---");
        DeadlineNotifier deadlineNotifier = new DeadlineNotifier();
        deadlineNotifier.registerObserver(student1);
        deadlineNotifier.registerObserver(admin);
        
        deadlineNotifier.addDocument(learningAgreement);
        
        System.out.println("\n--- 6. STRATEGY PATTERN: Activity Recommendations ---");
        List<Activity> allActivities = new ArrayList<>();
        allActivities.add(culturalNight);
        allActivities.add(techWorkshop);
        allActivities.add(new Activity("ACT003", "Football Tournament", 
                "Inter-university sports competition", "Sports", "Bucharest", 
                "2025-11-22", "Sports Club", 50));
        allActivities.add(new Activity("ACT004", "Traditional Music Concert", 
                "Romanian folk music performance", "Culture", "Cluj", 
                "2025-11-18", "Cultural Center", 80));
        
        RecommendationEngine engine = new RecommendationEngine(new InterestBasedRecommendation());
        
        System.out.println("\n>> Interest-Based Recommendations for " + student1.getName() + ":");
        List<Activity> recommendations = engine.getRecommendations(student1, allActivities);
        for (Activity activity : recommendations) {
            System.out.println("  - " + activity.getName() + " (" + activity.getType() + ")");
        }
        
        engine.setStrategy(new LocationBasedRecommendation());
        System.out.println("\n>> Location-Based Recommendations for " + student1.getName() + ":");
        recommendations = engine.getRecommendations(student1, allActivities);
        for (Activity activity : recommendations) {
            System.out.println("  - " + activity.getName() + " in " + activity.getLocation());
        }
        
        engine.setStrategy(new UniversityBasedRecommendation());
        System.out.println("\n>> University-Based Recommendations for " + student1.getName() + ":");
        recommendations = engine.getRecommendations(student1, allActivities);
        for (Activity activity : recommendations) {
            System.out.println("  - " + activity.getName() + " by " + activity.getOrganizer());
        }
        
        System.out.println("\n=== ALL DESIGN PATTERNS DEMONSTRATED SUCCESSFULLY ===");
        System.out.println("\nPattern Summary:");
        System.out.println("1. Factory Method - Created different user types (Student, Mentor, Admin)");
        System.out.println("2. Builder - Constructed complex UserProfile and Document objects");
        System.out.println("3. Observer - Enabled notifications for activities and deadlines");
        System.out.println("4. Strategy - Implemented flexible recommendation algorithms");
    }
}
