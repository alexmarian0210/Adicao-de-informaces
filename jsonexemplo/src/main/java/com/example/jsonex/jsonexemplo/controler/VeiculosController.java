package com.example.jsonex.jsonexemplo.controler;

import com.example.jsonex.jsonexemplo.model.Veiculos;
import com.example.jsonex.jsonexemplo.service.VeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class VeiculosController {

    @Autowired
    private VeiculosService veiculosService;

    // 1. Listar Veículos
    @GetMapping("/veiculos")
    public String listarVeiculos(Model model) {
        List<Veiculos> listaVeiculos = veiculosService.listarTodos();
        model.addAttribute("veiculos", listaVeiculos);
        return "veiculos";
    }

    // 2. Abrir formulário de Novo Veículo
    @GetMapping("/veiculos/novo")
    public String exibirFormularioNovo(Model model) {
        model.addAttribute("veiculo", new Veiculos());
        return "formulario-veiculo";
    }

    // 3. Salvar Novo Veículo
    @PostMapping("/veiculos")
    public String salvarVeiculo(@ModelAttribute Veiculos veiculo) {
        veiculosService.salvar(veiculo);
        return "redirect:/veiculos";
    }

    // 4. Abrir formulário para Editar Veículo existente
    @GetMapping("/veiculos/{id}/editar")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {
        Veiculos veiculo = veiculosService.buscarPorId(id);
        model.addAttribute("veiculo", veiculo);
        return "formulario-veiculo"; 
    }

    // 5. Salvar Veículo Editado
    @PostMapping("/veiculos/{id}/editar")
    public String atualizarVeiculo(@PathVariable Long id, @ModelAttribute Veiculos veiculo) {
        veiculo.setId(id); 
        veiculosService.salvar(veiculo);
        return "redirect:/veiculos";
    }

    // 6. Excluir Veículo
    @PostMapping("/veiculos/{id}/excluir")
    public String excluirVeiculo(@PathVariable Long id) {
        veiculosService.excluir(id);
        return "redirect:/veiculos";
    }
}