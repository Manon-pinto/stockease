package com.stockease.api.controller;


import com.stockease.api.model.Produit;
import com.stockease.api.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.findAll();
    }

    @GetMapping("/{id}")
    //public Produit getProduitById(@PathVariable Long id) {
    //    return produitService.findById(id);
    //}
    public Optional<Produit> findById(Long id) {
        return produitRepository.findById(id); // Garder le Optional
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        produit.setId(id);
        return produitService.save(produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteById(id);
    }
}