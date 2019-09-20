package com.lanzendorf.receita.api.repository;

import com.lanzendorf.receita.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
