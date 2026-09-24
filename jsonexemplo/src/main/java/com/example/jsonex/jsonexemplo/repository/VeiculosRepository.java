package com.example.jsonex.jsonexemplo.repository;

import com.example.jsonex.jsonexemplo.model.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {
}