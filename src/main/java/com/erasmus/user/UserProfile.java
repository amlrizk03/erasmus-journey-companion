package com.erasmus.user;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private String bio;
    private String nationality;
    private String university;
    private String fieldOfStudy;
    private List<String> interests;
    private String location;
    private String phoneNumber;
    private String emergencyContact;

    private UserProfile(UserProfileBuilder builder) {
        this.bio = builder.bio;
        this.nationality = builder.nationality;
        this.university = builder.university;
        this.fieldOfStudy = builder.fieldOfStudy;
        this.interests = builder.interests;
        this.location = builder.location;
        this.phoneNumber = builder.phoneNumber;
        this.emergencyContact = builder.emergencyContact;
    }

    public String getBio() { return bio; }
    public String getNationality() { return nationality; }
    public String getUniversity() { return university; }
    public String getFieldOfStudy() { return fieldOfStudy; }
    public List<String> getInterests() { return interests; }
    public String getLocation() { return location; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmergencyContact() { return emergencyContact; }

    @Override
    public String toString() {
        return "UserProfile{" +
                "bio='" + bio + '\'' +
                ", nationality='" + nationality + '\'' +
                ", university='" + university + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", interests=" + interests +
                ", location='" + location + '\'' +
                '}';
    }

    public static class UserProfileBuilder {
        private String bio;
        private String nationality;
        private String university;
        private String fieldOfStudy;
        private List<String> interests;
        private String location;
        private String phoneNumber;
        private String emergencyContact;

        public UserProfileBuilder() {
            this.interests = new ArrayList<>();
        }

        public UserProfileBuilder bio(String bio) {
            this.bio = bio;
            return this;
        }

        public UserProfileBuilder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public UserProfileBuilder university(String university) {
            this.university = university;
            return this;
        }

        public UserProfileBuilder fieldOfStudy(String fieldOfStudy) {
            this.fieldOfStudy = fieldOfStudy;
            return this;
        }

        public UserProfileBuilder addInterest(String interest) {
            this.interests.add(interest);
            return this;
        }

        public UserProfileBuilder interests(List<String> interests) {
            this.interests = new ArrayList<>(interests);
            return this;
        }

        public UserProfileBuilder location(String location) {
            this.location = location;
            return this;
        }

        public UserProfileBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserProfileBuilder emergencyContact(String emergencyContact) {
            this.emergencyContact = emergencyContact;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this);
        }
    }
}
