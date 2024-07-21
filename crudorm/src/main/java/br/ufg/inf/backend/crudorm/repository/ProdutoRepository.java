package br.ufg.inf.backend.crudorm.repository;

import br.ufg.inf.backend.crudorm.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
