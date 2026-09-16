package com.example.jsonex.jsonexemplo.controler;

import com.example.jsonex.jsonexemplo.model.Aluno;
import com.example.jsonex.jsonexemplo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/alunos")
    public String listarAlunos(@RequestParam(value = "busca", required = false) String busca, Model model) {
        List<Aluno> listaAlunos;

        if (busca != null && !busca.trim().isEmpty()) {
            // a busca  por nome 
            listaAlunos = alunoService.buscarPorNome(busca);
        } else {
            listaAlunos = alunoService.listarTodos();
        }

        model.addAttribute("alunos", listaAlunos);
        model.addAttribute("termoBusca", busca);

        return "alunos";
    }
}