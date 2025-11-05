package com.erasmus.activity;

import com.erasmus.notification.Subject;
import com.erasmus.notification.Observer;
import java.util.ArrayList;
import java.util.List;

public class Activity implements Subject {
    private String activityId;
    private String name;
    private String description;
    private String type;
    private String location;
    private String date;
    private String organizer;
    private int maxParticipants;
    private List<Observer> subscribers;

    public Activity(String activityId, String name, String description, String type, 
                    String location, String date, String organizer, int maxParticipants) {
        this.activityId = activityId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.location = location;
        this.date = date;
        this.organizer = organizer;
        this.maxParticipants = maxParticipants;
        this.subscribers = new ArrayList<>();
    }

    public String getActivityId() { return activityId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getType() { return type; }
    public String getLocation() { return location; }
    public String getDate() { return date; }
    public String getOrganizer() { return organizer; }
    public int getMaxParticipants() { return maxParticipants; }

    public void setDescription(String description) {
        this.description = description;
        notifyObservers("Activity '" + name + "' has been updated: " + description);
    }

    public void setDate(String date) {
        this.date = date;
        notifyObservers("Activity '" + name + "' date changed to: " + date);
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!subscribers.contains(observer)) {
            subscribers.add(observer);
            System.out.println("User subscribed to activity: " + name);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
        System.out.println("User unsubscribed from activity: " + name);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : subscribers) {
            observer.update(message);
        }
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + activityId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", organizer='" + organizer + '\'' +
                '}';
    }
}
