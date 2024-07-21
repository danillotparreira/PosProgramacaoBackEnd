package br.ufg.inf.backend.crudorm.repository;

import br.ufg.inf.backend.crudorm.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContaining(String nome);

    @Query("SELECT p FROM Produto p WHERE p.preco > :preco")
    List<Produto> findProdutosComPrecoMaiorQue(@Param("preco") double preco);

}
