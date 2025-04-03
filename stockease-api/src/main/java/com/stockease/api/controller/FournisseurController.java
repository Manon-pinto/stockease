package com.stockease.api.controller;

import com.stockease.api.model.Fournisseur;
import com.stockease.api.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurService.findAll();
    }

    @GetMapping("/{id}")
    public Fournisseur getFournisseurById(@PathVariable Long id) {
        return fournisseurService.findById(id);
    }

    @PostMapping
    public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.save(fournisseur);
    }

    @PutMapping("/{id}")
    public Fournisseur updateFournisseur(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {
        fournisseur.setId(id);
        return fournisseurService.save(fournisseur);
    }

    @DeleteMapping("/{id}")
    public void deleteFournisseur(@PathVariable Long id) {
        fournisseurService.delete(id);
    }
}
