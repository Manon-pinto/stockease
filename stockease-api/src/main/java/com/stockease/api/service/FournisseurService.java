package com.stockease.api.service;


import com.stockease.api.model.Fournisseur;
import com.stockease.api.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    public List<Fournisseur> findAll() {
        return fournisseurRepository.findAll();
    }

    public Fournisseur findById(Long id) {
        return fournisseurRepository.findById(id).orElse(null);
    }

    public Fournisseur save(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public void delete(Long id) {
        fournisseurRepository.deleteById(id);
    }
}