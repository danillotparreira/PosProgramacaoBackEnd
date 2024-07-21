package br.ufg.inf.backend.crudorm.rest;

import br.ufg.inf.backend.crudorm.model.Produto;
import br.ufg.inf.backend.crudorm.service.ProdutoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoRest {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar() {
        return produtoService.findall();
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Produto produto = produtoService.findById(id);
        if (produto != null) {
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            return ResponseEntity.ok(produtoService.save(produto));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> excluirProduto(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
