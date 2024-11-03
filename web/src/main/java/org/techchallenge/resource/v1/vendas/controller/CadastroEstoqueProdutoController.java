package org.techchallenge.resource.v1.vendas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techchallenge.resource.v1.response.Resposta;
import org.techchallenge.resource.v1.vendas.request.CadastroEstoqueProdutoRequest;
import org.techchallenge.vendas.application.service.CadastroEstoqueProdutoService;

@RestController
@RequestMapping("/estoques")
@RequiredArgsConstructor
public class CadastroEstoqueProdutoController {

    private final CadastroEstoqueProdutoService cadastroEstoqueProdutoService;

    @PostMapping
    public ResponseEntity<Resposta> cadastrar(@RequestBody @Valid CadastroEstoqueProdutoRequest request) {
        this.cadastroEstoqueProdutoService.cadastrar(request.sku(), request.quantidade());
        return new ResponseEntity<>(Resposta.criar(), HttpStatus.CREATED);
    }

}
