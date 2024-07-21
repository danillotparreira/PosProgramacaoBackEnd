package br.ufg.inf.backend.crudorm.service;

import br.ufg.inf.backend.crudorm.repository.CategoriaRepository;
import br.ufg.inf.backend.crudorm.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
}
