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
        System.out.println("\nERASMUS JOURNEY COMPANION - DESIGN PATTERNS DEMO \n");
        
        System.out.println("1. FACTORY METHOD PATTERN: Creating Users");
        User student1 = UserFactory.createUser("STUDENT", "1234", "Aml Rizk", "amlrizk03@email.com");
        User student2 = UserFactory.createUser("STUDENT", "1235", "John Carlos", "johncarlos@email.com");
        User mentor = UserFactory.createUser("MENTOR", "4576", "Prof. Schmidt", "schmidt@uni.edu");
        User admin = UserFactory.createUser("ADMIN", "8675", "Lisa Chen", "lisa.chen@admin.eu");
        
        System.out.println("Created: " + student1.getName() + " - " + student1.getRole());
        System.out.println("Created: " + student2.getName() + " - " + student2.getRole());
        System.out.println("Created: " + mentor.getName() + " - " + mentor.getRole());
        System.out.println("Created: " + admin.getName() + " - " + admin.getRole());
        
        System.out.println("\n2. BUILDER PATTERN: Building User Profiles");
        UserProfile amlProfile = new UserProfile.UserProfileBuilder()
                .bio("Software Engineering student from Egypt")
                .nationality("Egyptian")
                .university("Politehnica Bucharest")
                .fieldOfStudy("Software Engineering")
                .addInterest("Technology")
                .addInterest("Culture")
                .addInterest("Travelling")
                .location("Bucharest")
                .phoneNumber("+90-552-712-47-60")
                .emergencyContact("+34-987-654-321")
                .build();
        
        student1.setProfile(amlProfile);
        System.out.println("Profile created for " + student1.getName() + ":");
        System.out.println(amlProfile);
        
        UserProfile johnProfile = new UserProfile.UserProfileBuilder()
                .bio("Engineering student from Spain")
                .nationality("Spanish")
                .university("Politehnica Bucharest")
                .fieldOfStudy("Mechanical Engineering")
                .addInterest("Culture")
                .addInterest("Music")
                .location("Bucharest")
                .build();
        
        student2.setProfile(johnProfile );
        System.out.println("\nProfile created for " + student2.getName());
        
        System.out.println("\n3. BUILDER PATTERN: Creating Documents ");
        Document learningAgreement = new Document.DocumentBuilder("DOC001", "S001", "Learning_Agreement.pdf")
                .fileType("PDF")
                .category("Academic")
                .deadline(LocalDate.now().plusDays(5))
                .description("Signed learning agreement for Spring 2025")
                .filePath("/documents/learning_agreement.pdf")
                .build();
        
        System.out.println("Document created: " + learningAgreement);
        
        System.out.println("\n 4. OBSERVER PATTERN: Activity Notifications");
        Activity culturalDay = new Activity(
                "ACT001",
                "International Cultural Day",
                "Experience cultures from around the world with new friends, food, and performances",
                "Culture",
                "Old town, Bucharest",
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
        
        culturalDay.registerObserver(student1);
        culturalDay.registerObserver(student2);
        culturalDay.registerObserver(mentor);
        
        techWorkshop.registerObserver(student1);
        
        System.out.println("\nUpdating activity information:");
        culturalDay.setDate("2025-11-16");
        
        System.out.println("\n 5. OBSERVER PATTERN: Deadline Notifications ");
        DeadlineNotifier deadlineNotifier = new DeadlineNotifier();
        deadlineNotifier.registerObserver(student1);
        deadlineNotifier.registerObserver(admin);
        
        deadlineNotifier.addDocument(learningAgreement);
        
        System.out.println("\n 6. STRATEGY PATTERN: Activity Recommendations ");
        List<Activity> allActivities = new ArrayList<>();
        allActivities.add(culturalDay);
        allActivities.add(techWorkshop);
        allActivities.add(new Activity("ACT003", "City Tour",
                "Explore Bucharest through new eyes", "Travelling", "Bucharest",
                "2025-11-22", "Travellers Club", 50));
        allActivities.add(new Activity("ACT004", "Traditional Music Concert", 
                "Romanian folk music performance", "Culture", "Cluj", 
                "2025-11-18", "Cultural Center", 80));
        
        RecommendationEngine engine = new RecommendationEngine(new InterestBasedRecommendation());
        
        System.out.println("\nInterest-Based Recommendations for " + student1.getName() + ":");
        List<Activity> recommendations = engine.getRecommendations(student1, allActivities);
        for (Activity activity : recommendations) {
            System.out.println("  - " + activity.getName() + " (" + activity.getType() + ")");
        }
        
        engine.setStrategy(new LocationBasedRecommendation());
        System.out.println("\nLocation-Based Recommendations for " + student1.getName() + ":");
        recommendations = engine.getRecommendations(student1, allActivities);
        for (Activity activity : recommendations) {
            System.out.println("  - " + activity.getName() + " in " + activity.getLocation());
        }
        
        engine.setStrategy(new UniversityBasedRecommendation());
        System.out.println("\nUniversity-Based Recommendations for " + student1.getName() + ":");
        recommendations = engine.getRecommendations(student1, allActivities);
        for (Activity activity : recommendations) {
            System.out.println("  - " + activity.getName() + " by " + activity.getOrganizer());
        }

    }
}
