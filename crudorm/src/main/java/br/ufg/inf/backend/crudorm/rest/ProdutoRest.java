package br.ufg.inf.backend.crudorm.rest;

import br.ufg.inf.backend.crudorm.model.Produto;
import br.ufg.inf.backend.crudorm.service.ProdutoService;
import br.ufg.inf.backend.crudorm.utils.GenericRest;
import br.ufg.inf.backend.crudorm.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoRest extends GenericRest<Produto> {
    @Autowired
    private ProdutoService service;

    @Override
    protected GenericService<Produto> getService() {
        return service;
    }

    @Override
    protected void atualizarEntidade(Produto entidade, Produto entidadeAtualizada) {
        entidade.setNome(entidadeAtualizada.getNome());
        entidade.setPreco(entidadeAtualizada.getPreco());
    }
}
