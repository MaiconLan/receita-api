package com.lanzendorf.receita.api.resource;

import com.lanzendorf.receita.api.model.ListaCompra;
import com.lanzendorf.receita.api.service.ListaCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lista-compra")
public class ListaCompraEndpoint {

    @Autowired
    private ListaCompraService listaCompraService;

    @PostMapping
    public ResponseEntity<ListaCompra> salvar(@Valid @RequestBody ListaCompra listaCompra) {
        ListaCompra listaCompraSalva = listaCompraService.salvar(listaCompra);
        return ResponseEntity.status(HttpStatus.CREATED).body(listaCompraSalva);
    }

    @GetMapping
    public List<ListaCompra> listar() {
        return listaCompraService.listar();
    }

    @GetMapping("/{idListaCompra}")
    public ResponseEntity<ListaCompra> buscar(@PathVariable Long idListaCompra) {
        Optional<ListaCompra> optional = listaCompraService.obterListaCompra(idListaCompra);
        return optional.isPresent() ? ResponseEntity.ok(optional.get()) : ResponseEntity.notFound().build();
    }

}
