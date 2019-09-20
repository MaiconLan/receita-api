package com.lanzendorf.receita.api.resource;

import com.lanzendorf.receita.api.model.Produto;
import com.lanzendorf.receita.api.model.dto.ProdutoDTO;
import com.lanzendorf.receita.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoEndpoint {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvar(@RequestBody @Valid ProdutoDTO produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvar(produto));
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<Produto> buscar(@PathVariable Long idProduto) {
        Optional<Produto> optional = produtoService.obterProduto(idProduto);
        return optional.isPresent() ? ResponseEntity.ok(optional.get()) : ResponseEntity.noContent().build();
    }

}
