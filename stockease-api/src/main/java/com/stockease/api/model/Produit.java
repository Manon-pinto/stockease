package com.stockease.api.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nom;
    private String description;
    private BigDecimal prix;
    private int quantite;
    private LocalDate date_entree;
    private LocalDate date_sortie;

    @ManyToOne
    @JoinColumn(name = "id_Fournisseur", nullable = false)
    private Fournisseur fournisseur; // Cette ligne semble être manquante

    // Constructeur par défaut
    public Produit() {}

    // Constructeur avec paramètres
    public Produit(String nom, String description, BigDecimal prix, int quantite, LocalDate dateEntree, LocalDate dateSortie, Fournisseur fournisseur) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.date_entree = dateEntree;
        this.date_sortie = dateSortie;
        this.fournisseur = fournisseur;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public int getStock() {
        return quantite;
    }

    public void setStock(int stock) {
        this.quantite = quantite;
    }

    public LocalDate getDate_entree() {
        return date_entree;
    }

    public void setDate_entree(LocalDate date_entree) {
        this.date_entree = date_entree;
    }

    public LocalDate getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(LocalDate date_sortie) {
        this.date_sortie = date_sortie;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
}

