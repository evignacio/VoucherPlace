package org.techchallenge.resource.v1.vendas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techchallenge.resource.v1.Resposta;
import org.techchallenge.resource.v1.vendas.request.CadastroProdutoRequest;
import org.techchallenge.vendas.application.service.CadastroProdutoService;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class CadastroProdutoController {

    private final CadastroProdutoService cadastroProdutoService;

    @PostMapping
    public ResponseEntity<Resposta<Void>> cadastrar(@RequestBody @Valid CadastroProdutoRequest request) {
        this.cadastroProdutoService.cadastrar(request.nome(), request.sku(), request.fabricante(), request.preco());
        return new ResponseEntity<>(Resposta.criar(), HttpStatus.CREATED);
    }

}
