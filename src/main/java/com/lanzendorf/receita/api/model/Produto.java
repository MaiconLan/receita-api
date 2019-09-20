package com.lanzendorf.receita.api.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @NotNull
    private String nome;


    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo")
    private Tipo tipo;

}
