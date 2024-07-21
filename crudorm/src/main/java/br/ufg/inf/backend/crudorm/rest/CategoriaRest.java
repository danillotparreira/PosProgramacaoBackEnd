package br.ufg.inf.backend.crudorm.rest;

import br.ufg.inf.backend.crudorm.model.Categoria;
import br.ufg.inf.backend.crudorm.service.CategoriaService;
import br.ufg.inf.backend.crudorm.utils.GenericRest;
import br.ufg.inf.backend.crudorm.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaRest extends GenericRest<Categoria, CategoriaService> {
//    @Autowired
//    private CategoriaService service;
//
//    @Override
//    protected GenericService<Categoria> getService() {
//        return service;
//    }

    @Override
    protected void atualizarEntidade(Categoria entidade, Categoria entidadeAtualizada) {
        entidade.setNome(entidadeAtualizada.getNome());
    }
}
