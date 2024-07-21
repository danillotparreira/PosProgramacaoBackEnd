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
public class Categoria extends SuperEntidade {

    private String nome;
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;
}
