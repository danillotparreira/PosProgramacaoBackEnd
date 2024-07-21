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
public class Produto  extends SuperEntidade {

    private String nome;
    private double preco;

    @ManyToOne
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "produto_tag",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;
}
