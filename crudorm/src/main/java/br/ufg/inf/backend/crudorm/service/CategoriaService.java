package br.ufg.inf.backend.crudorm.service;

import br.ufg.inf.backend.crudorm.model.Categoria;
import br.ufg.inf.backend.crudorm.model.Tag;
import br.ufg.inf.backend.crudorm.repository.CategoriaRepository;
import br.ufg.inf.backend.crudorm.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends GenericService<Categoria> {

    @Autowired
    private CategoriaRepository repository;

    @Override
    protected JpaRepository<Categoria, Long> getRepository() {
        return repository;
    }
}
