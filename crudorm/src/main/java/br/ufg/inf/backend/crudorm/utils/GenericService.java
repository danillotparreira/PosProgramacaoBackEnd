package br.ufg.inf.backend.crudorm.utils;

import br.ufg.inf.backend.crudorm.model.abstracts.SuperEntidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class GenericService<E extends SuperEntidade,R extends JpaRepository<E, Long>> {

    @Autowired
    protected R repository;

    public E findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public E save(E entidade) {
        return repository.save(entidade);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
