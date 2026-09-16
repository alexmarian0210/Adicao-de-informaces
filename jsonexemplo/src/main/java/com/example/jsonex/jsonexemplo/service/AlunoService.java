package com.example.jsonex.jsonexemplo.service;

import com.example.jsonex.jsonexemplo.model.Aluno;
import com.example.jsonex.jsonexemplo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // 1. Método para listar todos os alunos (usado no GetMapping)
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    // 2. Método para buscar alunos por nome (usado na pesquisa)
    public List<Aluno> buscarPorNome(String nome) {
        // Se você tiver um método diferente no repository, adapte aqui
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }

    // 3. O MÉTODO QUE ESTAVA FALTANDO PARA SALVAR
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Adicione este método caso ainda não tenha
    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de aluno inválido: " + id));
    }
}