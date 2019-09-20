package com.lanzendorf.receita.api.service;

import com.lanzendorf.receita.api.model.ListaCompra;
import com.lanzendorf.receita.api.repository.ListaCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaCompraService {

    @Autowired
    private ListaCompraRepository listaCompraRepository;

    public ListaCompra salvar(ListaCompra listaCompra) {
        return listaCompraRepository.save(listaCompra);
    }


    public List<ListaCompra> listar() {
        return listaCompraRepository.findAll();
    }

    public Optional<ListaCompra> obterListaCompra(Long idListaCompra) {
        return listaCompraRepository.findById(idListaCompra);
    }
}
