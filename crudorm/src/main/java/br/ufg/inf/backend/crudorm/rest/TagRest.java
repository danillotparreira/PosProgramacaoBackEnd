package br.ufg.inf.backend.crudorm.rest;

import br.ufg.inf.backend.crudorm.model.Tag;
import br.ufg.inf.backend.crudorm.service.TagService;
import br.ufg.inf.backend.crudorm.utils.GenericRest;
import br.ufg.inf.backend.crudorm.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tags")
public class TagRest extends GenericRest<Tag> {
    @Autowired
    private TagService service;

    @Override
    protected GenericService<Tag> getService() {
        return service;
    }

    @Override
    protected void atualizarEntidade(Tag entidade, Tag entidadeAtualizada) {
        entidade.setNome(entidadeAtualizada.getNome());
    }
}
