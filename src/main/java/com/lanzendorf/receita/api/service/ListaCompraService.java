package com.lanzendorf.receita.api.service;

import com.lanzendorf.receita.api.model.ListaCompra;
import com.lanzendorf.receita.api.repository.ListaCompraRepository;
import com.lanzendorf.receita.api.service.exception.ListaCompraServiceException;
import com.lanzendorf.receita.api.service.exception.ReceitaServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaCompraService {

    @Autowired
    private ListaCompraRepository listaCompraRepository;

    public ListaCompra salvar(ListaCompra listaCompra) throws ReceitaServiceException {
        validarListaCompra(listaCompra);
        return listaCompraRepository.save(listaCompra);
    }

    private void validarListaCompra(ListaCompra listaCompra) throws ListaCompraServiceException {
        if (StringUtils.isEmpty(listaCompra.getDescricao()))
            throw new ListaCompraServiceException("lista.compra.validacao.descricao.obrigatorio");

        if (listaCompra.getProdutos() == null || listaCompra.getProdutos().isEmpty())
            throw new ListaCompraServiceException("lista.compra.validacao.produtos.obrigatorio");

        if (listaCompra.getProdutos().stream().anyMatch(p -> StringUtils.isEmpty(p.getDescricao())))
            throw new ListaCompraServiceException("produto.validacao.descricao.obrigatorio");
    }

    public List<ListaCompra> listar() {
        return listaCompraRepository.findAll();
    }

    public Optional<ListaCompra> obterListaCompra(Long idListaCompra) {
        return listaCompraRepository.findById(idListaCompra);
    }

    public void removerListaCompra(Long idListaCompra) {
        listaCompraRepository.deleteById(idListaCompra);
    }
}
