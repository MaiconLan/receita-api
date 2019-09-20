package com.lanzendorf.receita.api.repository;

import com.lanzendorf.receita.api.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

    Optional<Tipo> findByNome(String nome);

}
