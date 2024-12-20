package org.techchallenge.resource.v1.vendas.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
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
import org.techchallenge.resource.v1.vendas.response.CadastroProdutoResponse;
import org.techchallenge.vendas.application.service.CadastroProdutoService;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Tag(name = "Produtos")
public class CadastroProdutoController {

    private final CadastroProdutoService cadastroProdutoService;

    @PostMapping
    public ResponseEntity<Resposta<CadastroProdutoResponse>> cadastrar(@RequestBody @Valid CadastroProdutoRequest request) {
        var sku = this.cadastroProdutoService.cadastrar(request.nome(), request.sku(), request.idEmpresa(), request.fabricante(), request.preco());
        return new ResponseEntity<>(Resposta.criar(new CadastroProdutoResponse(sku)), HttpStatus.CREATED);
    }

}
