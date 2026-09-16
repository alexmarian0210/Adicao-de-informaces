package com.example.jsonex.jsonexemplo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.jsonex.jsonexemplo.model.Aluno;
import com.example.jsonex.jsonexemplo.repository.AlunoRepository;

@Service
public class AlunoService {
    // O Service agora depende do Repository.
    private final AlunoRepository alunoRepository;

    // Injeção de dependência.
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // ==========================================
    // READ
    // LISTAR TODOS
    // ==========================================
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    // ==========================================
    // READ
    // BUSCAR POR ID
    // ==========================================
    public Aluno buscarPorId(Long id) {
        return alunoRepository
                .findById(id)
                .orElse(null);
    }

    // ==========================================
    // CREATE
    // ==========================================
    public Aluno cadastrar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // ==========================================
    // UPDATE
    // ==========================================
    public Aluno atualizar(
            Long id,
            Aluno alunoAtualizado) {
        // Busca o aluno existente.
        Aluno alunoExistente = buscarPorId(id);
        // Verifica se foi encontrado.
        if (alunoExistente == null) {
            return null;
        }
        // Atualiza os dados.
        alunoExistente.setNome(
                alunoAtualizado.getNome());
        alunoExistente.setIdade(
                alunoAtualizado.getIdade());
        alunoExistente.setCurso(
                alunoAtualizado.getCurso());
        alunoExistente.setEmail(
                alunoAtualizado.getEmail());
        alunoExistente.setMatricula(
                alunoAtualizado.getMatricula());
                
                
        // Salva novamente no banco.
        return alunoRepository.save(
                alunoExistente);
    }

    // ==========================================
    // DELETE
    // ==========================================
    public boolean excluir(Long id) {
        // Verifica se o registro existe.
        if (!alunoRepository.existsById(id)) {
            return false;
        }
        // Exclui do banco.
        alunoRepository.deleteById(id);
        return true;
    }
}
