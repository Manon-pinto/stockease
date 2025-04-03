package com.stockease.api.repository;

import com.stockease.api.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByStockLessThan(int stockIsLessThan);

    List<Produit> findByNomContainingIgnoreCase(String nom);
}
