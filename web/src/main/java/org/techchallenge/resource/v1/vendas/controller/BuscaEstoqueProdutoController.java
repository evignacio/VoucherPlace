package org.techchallenge.resource.v1.vendas.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techchallenge.resource.v1.Resposta;
import org.techchallenge.vendas.application.service.BuscarEstoquePorProdutoService;
import org.techchallenge.vendas.domain.entity.Estoque;

@RestController
@RequestMapping("/estoques")
@RequiredArgsConstructor
@Tag(name = "Estoque")
public class BuscaEstoqueProdutoController {

    private final BuscarEstoquePorProdutoService buscarEstoquePorProdutoService;

    @GetMapping("/{sku}")
    public ResponseEntity<Resposta<Estoque>> cadastrar(@PathVariable @Valid String sku) {
        var estoque = this.buscarEstoquePorProdutoService.buscar(sku);
        return new ResponseEntity<>(Resposta.criar(estoque), HttpStatus.OK);
    }

}
