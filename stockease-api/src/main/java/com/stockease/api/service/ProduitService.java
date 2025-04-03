package com.stockease.api.service;

import com.stockease.api.model.Produit;
import com.stockease.api.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockease.api.exception.ProduitNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProduitService {

    private final ProduitRepository produitRepository;

    // Injection par constructeur recommandée par Spring
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Page<Produit> findAllPaged(Pageable pageable) {
        return produitRepository.findAll(pageable);
    }

    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    public Optional<Produit> findById(Long id) {
        return produitRepository.findById(id);
    }

    public Produit getById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new ProduitNotFoundException("Produit non trouvé avec l'ID : " + id));
    }

    public Produit save(Produit produit) {
        validateProduit(produit);
        return produitRepository.save(produit);
    }

    public Produit update(Long id, Produit produitDetails) {
        Produit produit = getById(id);
        produit.setNom(produitDetails.getNom());
        produit.setDescription(produitDetails.getDescription());
        produit.setPrix(produitDetails.getPrix());
        produit.setStock(produitDetails.getStock());
        return save(produit);
    }

    public void deleteById(Long id) {
        Produit produit = getById(id);
        produitRepository.delete(produit);
    }

    public List<Produit> findByNomContaining(String nom) {
        return produitRepository.findByNomContainingIgnoreCase(nom);
    }

    public List<Produit> findProduitsEnRupture() {
        return produitRepository.findByStockLessThan(5);
    }

    private void validateProduit(Produit produit) {
        //if (produit.getPrix() <= 0) {
        if (produit.getPrix().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Le prix doit être positif");
        }
        if (produit.getStock() < 0) {
            throw new IllegalArgumentException("Le stock ne peut pas être négatif");
        }
    }
}