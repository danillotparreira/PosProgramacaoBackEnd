package br.ufg.inf.backend.crudorm.controller;


import br.ufg.inf.backend.crudorm.model.Produto;
import br.ufg.inf.backend.crudorm.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public String listarProdutos(Model model, @RequestParam(required = false) String sucesso) {
        model.addAttribute("produtos", produtoService.findall());
        model.addAttribute("sucesso", sucesso);
        return "produtos";
    }

    @GetMapping("/produtos/adicionar")
    public String mostrarFormularioAdicionarProduto() {
        return "adicionar-produto";
    }

    @PostMapping("/produtos")
    public String adicionarProduto(@RequestParam String nome, @RequestParam double preco, RedirectAttributes redirectAttributes) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produtoService.save(produto);
        redirectAttributes.addAttribute("sucesso", "Produto adicionado com sucesso!");
        return "redirect:/produtos";
    }
}