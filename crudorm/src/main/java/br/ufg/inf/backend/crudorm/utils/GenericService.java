package br.ufg.inf.backend.crudorm.utils;

import br.ufg.inf.backend.crudorm.model.abstracts.SuperEntidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class GenericService<E extends SuperEntidade> {

    protected abstract JpaRepository<E, Long> getRepository();

    public E findById(Long id) {
        return getRepository().findById(id).orElse(null);
    }

    public List<E> findAll() {
        return getRepository().findAll();
    }

    public E save(E entidade) {
        return getRepository().save(entidade);
    }

    public void delete(Long id) {
        getRepository().deleteById(id);
    }

}
