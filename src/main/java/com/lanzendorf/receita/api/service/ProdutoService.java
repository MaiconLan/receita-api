package com.lanzendorf.receita.api.service;

import com.lanzendorf.receita.api.model.Produto;
import com.lanzendorf.receita.api.model.Tipo;
import com.lanzendorf.receita.api.model.dto.ProdutoDTO;
import com.lanzendorf.receita.api.repository.ProdutoRepository;
import com.lanzendorf.receita.api.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private TipoRepository tipoRepository;

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
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());

        Optional<Tipo> optionalTipo = tipoRepository.findByNome(produtoDTO.getTipo());

        Tipo tipo;
        if(optionalTipo.isPresent()) {
            tipo = optionalTipo.get();

        } else {
            tipo = new Tipo();
            tipo.setNome(produtoDTO.getTipo());
        }

        produto.setTipo(tipo);

        return produto;
    }

    private ProdutoDTO converter(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setIdProduto(produto.getIdProduto());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setTipo(produto.getTipo().getNome());

        return produtoDTO;
    }
}
