package com.example.jsonex.jsonexemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jsonex.jsonexemplo.model.Aluno;

// Interface responsável pelo acesso ao banco de dados.
//
// Aluno = entidade manipulada
// Long = tipo da chave primária
public interface AlunoRepository
        extends JpaRepository<Aluno, Long> {
}