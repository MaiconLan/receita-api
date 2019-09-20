package com.lanzendorf.receita.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lista_compra")
public class ListaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_compra")
    private Long idListaCompra;

    @NotNull
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "produto_lista_compra", joinColumns = @JoinColumn(name = "id_lista_compra")
            , inverseJoinColumns = @JoinColumn(name = "id_produto"))
    private List<Produto> produtos;

}
