package br.ufg.inf.backend.crudorm.service;

import br.ufg.inf.backend.crudorm.model.Categoria;
import br.ufg.inf.backend.crudorm.repository.CategoriaRepository;
import br.ufg.inf.backend.crudorm.utils.GenericService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends GenericService<Categoria, CategoriaRepository> {
}
