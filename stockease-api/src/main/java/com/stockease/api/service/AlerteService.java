package com.stockease.api.service;

import com.stockease.api.model.Alerte;
import com.stockease.api.repository.AlerteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlerteService {
    @Autowired
    private AlerteRepository alerteRepository;

    public List<Alerte> findAll() {
        return alerteRepository.findAll();
    }

    public Alerte findById(Long id) {
        return alerteRepository.findById(id).orElse(null);
    }

    public Alerte save(Alerte alerte) {
        return alerteRepository.save(alerte);
    }

    public void delete(Long id) {
        alerteRepository.deleteById(id);
    }
}