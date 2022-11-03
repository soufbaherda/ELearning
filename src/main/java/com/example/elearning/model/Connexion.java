package com.example.elearning.model;

public class Connexion {
    private long id;
    private String status;
    private String name;



    private String role;

    public Connexion(long id, String status, String name, String role) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

