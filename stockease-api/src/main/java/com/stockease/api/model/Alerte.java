package com.stockease.api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Alerte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private LocalDate date_alerte;

    // Constructeurs
    public Alerte() {}

    public Alerte(String type, LocalDate date_alerte) {
        this.type = type;
        this.date_alerte = date_alerte;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate_alerte() {
        return date_alerte;
    }

    public void setDate_alerte(LocalDate date_alerte) {
        this.date_alerte = date_alerte;
    }
}