package com.erasmus.user;

public class UserFactory {
    
    public static User createUser(String userType, String userId, String name, String email) {
        if (userType == null || userType.isEmpty()) {
            throw new IllegalArgumentException("User type cannot be null or empty");
        }

        switch (userType.toUpperCase()) {
            case "STUDENT":
                return new Student(userId, name, email);
            case "MENTOR":
                return new Mentor(userId, name, email);
            case "ADMINISTRATOR":
            case "ADMIN":
                return new Administrator(userId, name, email);
            default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
        }
    }
}
