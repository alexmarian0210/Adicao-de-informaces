package com.example.jsonex.jsonexemplo.service;

import com.example.jsonex.jsonexemplo.model.Veiculos;
import com.example.jsonex.jsonexemplo.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculosService {

    @Autowired
    private VeiculosRepository veiculosRepository;

    public List<Veiculos> listarTodos() {
        return veiculosRepository.findAll();
    }

    public Veiculos buscarPorId(Long id) {
        return veiculosRepository.findById(id).orElse(null);
    }

    public void salvar(Veiculos veiculo) {
        veiculosRepository.save(veiculo);
    }

    public void excluir(Long id) {
        veiculosRepository.deleteById(id);
    }
}