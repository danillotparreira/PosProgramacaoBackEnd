package br.ufg.inf.backend.crudorm.model;

import br.ufg.inf.backend.crudorm.model.abstracts.SuperEntidade;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria extends SuperEntidade {

    private String nome;
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;
}
