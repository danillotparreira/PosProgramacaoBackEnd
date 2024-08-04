package br.ufg.inf.backend.crudorm.service;

import br.ufg.inf.backend.crudorm.model.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProdutoServiceTest {
    @Autowired
    private ProdutoService service;

    @Test
    public void testAddProduct() {
        String nome = "Teste";
        double preco = 100;

        Produto produto = new Produto(null, nome, preco);
        Produto produtoSalvo = service.save(produto);
        assertNotNull(produtoSalvo);
        assertNotNull(produtoSalvo.getId());
        assertEquals(nome, produtoSalvo.getNome());
        assertEquals(preco, produtoSalvo.getPreco());
    }
}