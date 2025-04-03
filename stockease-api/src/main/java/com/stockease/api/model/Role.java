package com.stockease.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    // Constructeurs
    public Role() {}

    public Role(String role) {
        this.role = role;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getrole() {
        return role;
    }
    public void setrole(String type) {
        this.role = role;
    }
}