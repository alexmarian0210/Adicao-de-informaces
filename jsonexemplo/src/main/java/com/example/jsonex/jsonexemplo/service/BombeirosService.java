package com.example.jsonex.jsonexemplo.service;

import com.example.jsonex.jsonexemplo.model.Bombeiros;
import com.example.jsonex.jsonexemplo.repository.BombeiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BombeirosService {

    @Autowired
    private BombeiroRepository bombeirosRepository;

    // 1. Método para listar todos os alunos (usado no GetMapping)
    public List<Bombeiros> listarTodos() {
        return bombeirosRepository.findAll();
    }

    // 2. Método para buscar alunos por nome (usado na pesquisa)
    public List<Bombeiros> buscarPorNome(String nome) {
        // Se você tiver um método diferente no repository, adapte aqui
        return bombeirosRepository.findByNomeContainingIgnoreCase(nome);
    }

    // 3. O MÉTODO QUE ESTAVA FALTANDO PARA SALVAR
    public Bombeiros salvar(Bombeiros bombeiros) {
        return bombeirosRepository.save(bombeiros);
    }

    // Adicione este método caso ainda não tenha
    public Bombeiros buscarPorId(Long id) {
        return bombeirosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de Bombeiro inválido: " + id));
    }

    // Método para excluir o aluno do banco de dados
    public void excluir(long id) {
        bombeirosRepository.deleteById(id);
    }
}