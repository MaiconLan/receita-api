package com.lanzendorf.receita.api.service;

import com.lanzendorf.receita.api.model.Produto;
import com.lanzendorf.receita.api.model.dto.ProdutoDTO;
import com.lanzendorf.receita.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.save(converter(produtoDTO));
        return converter(produto);
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterProduto(Long idProduto) {
        return produtoRepository.findById(idProduto);
    }

    private Produto converter(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setIdProduto(produtoDTO.getIdProduto());
        produto.setDescricao(produtoDTO.getDescricao());
        return produto;
    }

    private ProdutoDTO converter(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setIdProduto(produto.getIdProduto());
        produtoDTO.setDescricao(produto.getDescricao());
        return produtoDTO;
    }
}
