package br.ufg.inf.backend.crudorm.service;

import br.ufg.inf.backend.crudorm.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

}
