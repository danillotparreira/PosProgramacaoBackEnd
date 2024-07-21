package br.ufg.inf.backend.crudorm.service;

import br.ufg.inf.backend.crudorm.model.Tag;
import br.ufg.inf.backend.crudorm.repository.TagRepository;
import br.ufg.inf.backend.crudorm.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService extends GenericService<Tag> {

    @Autowired
    private TagRepository repository;

    @Override
    protected JpaRepository<Tag, Long> getRepository() {
        return repository;
    }
}
