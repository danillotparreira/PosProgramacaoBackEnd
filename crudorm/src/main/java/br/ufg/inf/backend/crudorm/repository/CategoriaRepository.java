package br.ufg.inf.backend.crudorm.repository;

import br.ufg.inf.backend.crudorm.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query("SELECT c FROM Categoria c JOIN FETCH c.produtos where c.id = :id")
    Categoria findCategoriaComProdutos(@Param("id") Long id);
}

