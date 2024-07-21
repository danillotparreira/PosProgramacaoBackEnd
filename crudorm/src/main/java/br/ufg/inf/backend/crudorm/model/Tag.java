package br.ufg.inf.backend.crudorm.model;

import br.ufg.inf.backend.crudorm.model.abstracts.SuperEntidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends SuperEntidade {

    private String nome;

    @ManyToMany(mappedBy = "tags")
    private List<Produto> produtos;
}
