package com.example.jsonex.jsonexemplo.repository;

import com.example.jsonex.jsonexemplo.model.Bombeiros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BombeiroRepository extends JpaRepository<Bombeiros, Long> {
    
    // Método que permite a busca por partes do nome ignorando letras maiúsculas/minúsculas
    List<Bombeiros> findByNomeContainingIgnoreCase(String nome);
}