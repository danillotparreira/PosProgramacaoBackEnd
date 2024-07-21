package br.ufg.inf.backend.crudorm.utils;

import br.ufg.inf.backend.crudorm.model.abstracts.SuperEntidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericRest<T extends SuperEntidade, R extends GenericService<T, ? extends JpaRepository<T, Long>>> {

    @Autowired
    protected R service;

    @GetMapping
    public List<T> listar() {
        return service.findAll();
    }

    @PostMapping
    public T adicionar(@RequestBody T entidade) {
        return service.save(entidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        T entidade = service.findById(id);
        return entidade != null ? ResponseEntity.ok(entidade) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody T entidadeAtualizada) {
        T entidade = service.findById(id);
        if (entidade != null) {
            atualizarEntidade(entidade, entidadeAtualizada);
            return ResponseEntity.ok(service.save(entidade));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    protected abstract void atualizarEntidade(T entidade, T entidadeAtualizada);
}