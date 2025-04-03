package com.stockease.api.repository;


import com.stockease.api.model.Alerte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlerteRepository extends JpaRepository<Alerte, Long> {
}
