package com.stockease.api.controller;


import com.stockease.api.model.Alerte;
import com.stockease.api.service.AlerteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerte")
public class AlerteController {

    @Autowired
    private AlerteService alerteService;

    @GetMapping
    public List<Alerte> getAllAlertes() {
        return alerteService.findAll();
    }

    @GetMapping("/{id}")
    public Alerte getAlerteById(@PathVariable Long id) {
        return alerteService.findById(id);
    }

    @PostMapping
    public Alerte createAlerte(@RequestBody Alerte alerte) {
        return alerteService.save(alerte);
    }

    @PutMapping("/{id}")
    public Alerte updateAlerte(@PathVariable Long id, @RequestBody Alerte alerte) {
        alerte.setId(id);
        return alerteService.save(alerte);
    }

    @DeleteMapping("/{id}")
    public void deleteAlerte(@PathVariable Long id) {
        alerteService.delete(id);
    }
}