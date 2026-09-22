package com.example.jsonex.jsonexemplo.controler;

import com.example.jsonex.jsonexemplo.model.Bombeiros;
import com.example.jsonex.jsonexemplo.service.BombeirosService;
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
public class BombeirosController {

    @Autowired
    private BombeirosService bombeirosService;

    // 1. Método para listar alunos e fazer a pesquisa
    @GetMapping("/bombeiros")
    public String listarBombeiros(@RequestParam(value = "busca", required = false) String busca, Model model) {
        List<Bombeiros> listaBombeiros;

        if (busca != null && !busca.trim().isEmpty()) {
            listaBombeiros = bombeirosService.buscarPorNome(busca);
        } else {
            listaBombeiros = bombeirosService.listarTodos();
        }

        model.addAttribute("bombeiros", listaBombeiros);
        model.addAttribute("termoBusca", busca);

        return "bombeiros";
    }

    // 2. Método para abrir a tela de cadastro
    @GetMapping("/bombeiros/novo")
    public String exibirFormularioNovoBombeiros(Model model) {
        model.addAttribute("bombeiro", new Bombeiros());
        
       
        return "formulario-bombeiro"; 
    }

    // 3. Método para receber os dados do form, salvar e voltar para a lista
    @PostMapping("/bombeiros")
    public String salvarBombeiros(@ModelAttribute Bombeiros bombeiro) {
        // Manda o service salvar o aluno no banco de dados
        bombeirosService.salvar(bombeiro); 
        
        // Redireciona de volta para a tela inicial (/alunos) após salvar
        return "redirect:/bombeiros"; 
    }

   // Mude a rota aqui
    @GetMapping("/bombeiros/{id}/editar")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {
        Bombeiros bombeiros = bombeirosService.buscarPorId(id);
        model.addAttribute("bombeiro", bombeiros);
        return "editar-bombeiros"; 
    }

    // Mude a rota aqui também
    @PostMapping("/bombeiros/{id}/editar")
    public String atualizarBombeiros(@PathVariable int id, @ModelAttribute Bombeiros bombeiro) {
        bombeiro.setId(id); 
        bombeirosService.salvar(bombeiro); 
        return "redirect:/bombeiros";
    }

    // 6. Recebe o clique do botão excluir e apaga o aluno
    @PostMapping("/bombeiros/{id}/excluir")
    public String excluirBombeiros(@PathVariable Long id) {
        bombeirosService.excluir(id); // Chama o service para deletar
        return "redirect:/bombeiros"; // Recarrega a página da lista
    }
}   