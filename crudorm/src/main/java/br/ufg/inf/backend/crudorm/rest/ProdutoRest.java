package br.ufg.inf.backend.crudorm.rest;

import br.ufg.inf.backend.crudorm.model.Produto;
import br.ufg.inf.backend.crudorm.service.ProdutoService;
import br.ufg.inf.backend.crudorm.utils.GenericRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoRest extends GenericRest<Produto, ProdutoService> {

    @Override
    protected void atualizarEntidade(Produto entidade, Produto entidadeAtualizada) {
        entidade.setNome(entidadeAtualizada.getNome());
        entidade.setPreco(entidadeAtualizada.getPreco());
    }
}
