package com.stockease.api.model;

import jakarta.persistence.*;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String mdp;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    // Constructeurs
    public Utilisateur() {}

    public Utilisateur(String nom, String email, String mdp, Role role) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
