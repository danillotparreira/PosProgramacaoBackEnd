package br.ufg.inf.backend.crudorm.service;

import br.ufg.inf.backend.crudorm.model.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class ProdutoServiceTest {
    @Autowired
    private ProdutoService service;

    @Test
    public void testAddProduto() {
        String nome = "Teste";
        double preco = 100.0;

        Produto produto = Produto.builder().nome(nome).preco(preco).build();
        Produto produtoSalvo = service.save(produto);

//        Assert.assertNotNull(produtoSalvo);

    }

}
