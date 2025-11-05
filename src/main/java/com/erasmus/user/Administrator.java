package com.erasmus.user;

public class Administrator extends User {
    private String department;
    private String accessLevel;

    public Administrator(String userId, String name, String email) {
        super(userId, name, email);
        this.accessLevel = "FULL";
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    @Override
    public String getRole() {
        return "ADMINISTRATOR";
    }
}
