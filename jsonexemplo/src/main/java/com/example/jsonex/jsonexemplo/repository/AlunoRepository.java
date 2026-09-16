package com.example.jsonex.jsonexemplo.repository;

import com.example.jsonex.jsonexemplo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
    // Método que permite a busca por partes do nome ignorando letras maiúsculas/minúsculas
    List<Aluno> findByNomeContainingIgnoreCase(String nome);
}