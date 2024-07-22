package br.ufg.inf.backend.crudorm.controller;


import br.ufg.inf.backend.crudorm.model.Produto;
import br.ufg.inf.backend.crudorm.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public String listarProdutos(Model model, @RequestParam(required = false) String sucesso) {
        model.addAttribute("produtos", produtoService.findAll());
        model.addAttribute("sucesso", sucesso);
        return "produtos";
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarProduto() {
        return "adicionar-produto";
    }

    @PostMapping()
    public String adicionarProduto(@RequestParam String nome, @RequestParam double preco, RedirectAttributes redirectAttributes) {
        Produto produto = Produto.builder().nome(nome).preco(preco).build();
//        Produto produto = new Produto();
//        produto.setNome(nome);
//        produto.setPreco(preco);
        produtoService.save(produto);
        redirectAttributes.addAttribute("sucesso", "Produto adicionado com sucesso!");
        return "redirect:/produtos";
    }


    @GetMapping("/editar")
    public String mostrarFormularioEditarProduto(@RequestParam("id") Long id, Model model) {
        Produto produto = produtoService.findById(id);
        model.addAttribute("produto", produto);
        return "editar-produto";
    }
    @PostMapping("/editar")
    public String editarProduto(@RequestParam("id") Long id, @RequestParam String nome, @RequestParam double preco, RedirectAttributes redirectAttributes){
        Produto produto = produtoService.findById(id);
        produto.setNome(nome);
        produto.setPreco(preco);
        produtoService.save(produto);
        redirectAttributes.addAttribute("sucesso", "Produto atualizado com sucesso!");
        return "redirect:/produtos";
    }
    @PostMapping("/deletar")
    public String deletarProduto(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        produtoService.delete(id);
        redirectAttributes.addAttribute("sucesso", "Produto removido com sucesso!");
        return "redirect:/produtos";
    }
}