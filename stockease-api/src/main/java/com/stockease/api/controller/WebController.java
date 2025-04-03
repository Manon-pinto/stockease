package com.stockease.api.controller;

import com.stockease.api.model.Produit;
import com.stockease.api.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produits")
public class WebController {

    private final ProduitService produitService;

    public WebController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public String listeProduits(Model model) {
        model.addAttribute("produits", produitService.findAll());
        return "produits";
    }

    @GetMapping("/formulaire")
    public String formulaireProduit(Model model) {
        model.addAttribute("produit", new Produit());
        return "formulaire-produit";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarderProduit(@ModelAttribute Produit produit) {
        produitService.save(produit);
        return "redirect:/produits";
    }

    @GetMapping("/editer/{id}")
    public String editerProduit(@PathVariable Long id, Model model) {
        model.addAttribute("produit", produitService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID produit invalide")));
        return "formulaire-produit";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerProduit(@PathVariable Long id) {
        produitService.deleteById(id);
        return "redirect:/produits";
    }
}
