package org.techchallenge.resource.v1.vendas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techchallenge.resource.v1.Resposta;
import org.techchallenge.vendas.application.service.BuscarEstoquePorProdutoService;
import org.techchallenge.vendas.domain.entity.Estoque;

@RestController
@RequestMapping("/estoques")
@RequiredArgsConstructor
public class BuscaEstoqueProdutoController {

    private final BuscarEstoquePorProdutoService buscarEstoquePorProdutoService;

    @GetMapping("/{sku}")
    public ResponseEntity<Resposta<Estoque>> cadastrar(@PathVariable @Valid String sku) {
        var estoque = this.buscarEstoquePorProdutoService.buscar(sku);
        return new ResponseEntity<>(Resposta.criar(estoque), HttpStatus.OK);
    }

}
