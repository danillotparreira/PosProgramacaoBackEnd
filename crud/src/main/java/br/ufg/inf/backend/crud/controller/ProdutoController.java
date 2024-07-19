package br.ufg.inf.backend.crud.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufg.inf.backend.crud.model.Produto;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	private List<Produto> produtos = new ArrayList<>();

	public ProdutoController() {
		produtos = Arrays.asList(new Produto(1L, "Notebook", 2000.00), new Produto(2L, "Smartphone", 1000.00));
	}

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
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		// Adicionando o produto à lista de produtos
		model.addAttribute("produtos", Arrays.asList(produto));
		model.addAttribute("sucesso", "Produto adicionado com sucesso!");
		return "produtos";
	}
}
