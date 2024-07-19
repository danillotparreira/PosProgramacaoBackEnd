package br.ufg.inf.backend.crud.controller;

import br.ufg.inf.backend.crud.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtos);
        return "produtos";
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarProduto() {
        return "adicionar-produto";
    }

    @PostMapping
    public String adicionarProduto(@RequestParam String nome, @RequestParam double preco, Model model) {
        try {
            addProduto(nome, preco);
            model.addAttribute("produtos", produtos);
            model.addAttribute("sucesso", "Produto adicionado com sucesso!");
        } catch (Exception e) {
            e.getMessage();
        }
        return "produtos";
    }

    private void addProduto(String nome, double preco) {
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setId(getProximoId());
        produtos.add(produto);
    }

    public Long getProximoId() {
        return produtos.stream()
                .map(Produto::getId)
                .max(Long::compare)
                .orElse(0L) + 1L;
    }
}
