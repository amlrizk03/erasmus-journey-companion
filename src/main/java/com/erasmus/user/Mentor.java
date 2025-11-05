package com.erasmus.user;

import java.util.ArrayList;
import java.util.List;

public class Mentor extends User {
    private String expertise;
    private List<String> assignedStudents;

    public Mentor(String userId, String name, String email) {
        super(userId, name, email);
        this.assignedStudents = new ArrayList<>();
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    public void addAssignedStudent(String studentId) {
        assignedStudents.add(studentId);
    }

    public List<String> getAssignedStudents() {
        return assignedStudents;
    }

    @Override
    public String getRole() {
        return "MENTOR";
    }
}
