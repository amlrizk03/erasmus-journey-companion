package com.erasmus.user;

import com.erasmus.notification.Observer;
import java.util.ArrayList;
import java.util.List;

public abstract class User implements Observer {
    protected String userId;
    protected String name;
    protected String email;
    protected UserProfile profile;
    protected List<String> notifications;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.notifications = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public abstract String getRole();

    @Override
    public void update(String message) {
        notifications.add(message);
        System.out.println("[" + getRole() + " " + name + "] received notification: " + message);
    }

    public void displayInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Role: " + getRole());
        if (profile != null) {
            System.out.println("Profile: " + profile);
        }
    }
}
