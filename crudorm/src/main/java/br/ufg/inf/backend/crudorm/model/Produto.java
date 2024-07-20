package br.ufg.inf.backend.crudorm.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Produto {
    private Long id;
    private String nome;
    private double preco;

}
