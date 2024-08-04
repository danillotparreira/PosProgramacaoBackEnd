package br.ufg.inf.backend.crudorm.model;

import br.ufg.inf.backend.crudorm.model.abstracts.SuperEntidade;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Categoria extends SuperEntidade {

    private String nome;
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;
}
