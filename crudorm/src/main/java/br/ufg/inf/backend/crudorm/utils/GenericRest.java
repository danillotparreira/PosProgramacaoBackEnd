package br.ufg.inf.backend.crudorm.utils;

import br.ufg.inf.backend.crudorm.model.abstracts.SuperEntidade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericRest<E extends SuperEntidade> {

    protected abstract GenericService<E> getService();

    @GetMapping
    public List<E> listar() {
        return getService().findAll();
    }

    @PostMapping
    public E adicionar(@RequestBody E entidade) {
        return getService().save(entidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        E entidade = getService().findById(id);
        return entidade != null ? ResponseEntity.ok(entidade) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody E entidadeAtualizada) {
        E entidade = getService().findById(id);
        if (entidade != null) {
            atualizarEntidade(entidade, entidadeAtualizada);
            return ResponseEntity.ok(getService().save(entidade));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.ok().build();
    }

    protected abstract void atualizarEntidade(E entidade, E entidadeAtualizada);
}