package com.lanzendorf.receita.api.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

    private Long idProduto;
    private String nome;
    private String descricao;
    private String tipo;

}
