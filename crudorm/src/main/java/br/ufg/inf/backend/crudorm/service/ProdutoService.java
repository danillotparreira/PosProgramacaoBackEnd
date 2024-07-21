package br.ufg.inf.backend.crudorm.service;

import br.ufg.inf.backend.crudorm.model.Produto;
import br.ufg.inf.backend.crudorm.repository.ProdutoRepository;
import br.ufg.inf.backend.crudorm.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService extends GenericService<Produto> {

    @Autowired
    private ProdutoRepository repository;

    @Override
    protected JpaRepository<Produto, Long> getRepository() {
        return repository;
    }
}
