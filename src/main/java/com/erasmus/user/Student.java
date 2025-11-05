package com.erasmus.user;

public class Student extends User {
    private String university;
    private String homeCountry;

    public Student(String userId, String name, String email) {
        super(userId, name, email);
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    public String getUniversity() {
        return university;
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    @Override
    public String getRole() {
        return "STUDENT";
    }
}
