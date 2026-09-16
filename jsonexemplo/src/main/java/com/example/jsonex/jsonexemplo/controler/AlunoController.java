package com.example.jsonex.jsonexemplo.controler;

import com.example.jsonex.jsonexemplo.model.Aluno;
import com.example.jsonex.jsonexemplo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // 1. Método para listar alunos e fazer a pesquisa
    @GetMapping("/alunos")
    public String listarAlunos(@RequestParam(value = "busca", required = false) String busca, Model model) {
        List<Aluno> listaAlunos;

        if (busca != null && !busca.trim().isEmpty()) {
            listaAlunos = alunoService.buscarPorNome(busca);
        } else {
            listaAlunos = alunoService.listarTodos();
        }

        model.addAttribute("alunos", listaAlunos);
        model.addAttribute("termoBusca", busca);

        return "alunos";
    }

    // 2. Método para abrir a tela de cadastro
    @GetMapping("/alunos/novo")
    public String exibirFormularioNovoAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        
       
        return "formulario-aluno"; 
    }

    // 3. Método para receber os dados do form, salvar e voltar para a lista
    @PostMapping("/alunos")
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        // Manda o service salvar o aluno no banco de dados
        alunoService.salvar(aluno); 
        
        // Redireciona de volta para a tela inicial (/alunos) após salvar
        return "redirect:/alunos"; 
    }

   // Mude a rota aqui
    @GetMapping("/alunos/{id}/editar")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id);
        model.addAttribute("aluno", aluno);
        return "editar-aluno"; 
    }

    // Mude a rota aqui também
    @PostMapping("/alunos/{id}/editar")
    public String atualizarAluno(@PathVariable Long id, @ModelAttribute Aluno aluno) {
        aluno.setId(id); 
        alunoService.salvar(aluno); 
        return "redirect:/alunos";
    }

    // 6. Recebe o clique do botão excluir e apaga o aluno
    @PostMapping("/alunos/{id}/excluir")
    public String excluirAluno(@PathVariable Long id) {
        alunoService.excluir(id); // Chama o service para deletar
        return "redirect:/alunos"; // Recarrega a página da lista
    }
}   