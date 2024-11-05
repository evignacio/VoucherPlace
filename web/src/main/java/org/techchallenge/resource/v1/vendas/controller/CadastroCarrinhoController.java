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
import org.techchallenge.resource.v1.vendas.request.CadastroCarrinhoRequest;
import org.techchallenge.resource.v1.vendas.response.CadastroCarrinhoResponse;
import org.techchallenge.resource.v1.vendas.response.CadastroProdutoResponse;
import org.techchallenge.vendas.application.service.CadastroCarrinhoService;

@RestController
@RequestMapping("/carrinhos")
@RequiredArgsConstructor
@Tag(name = "Carrinhos`")
public class CadastroCarrinhoController {

    private final CadastroCarrinhoService cadastroCarrinhoService;

    @PostMapping
    public ResponseEntity<Resposta<CadastroProdutoResponse>> cadastrar(@RequestBody @Valid CadastroCarrinhoRequest request) {
        var carrinho = this.cadastroCarrinhoService.cadastrar(request.sku(), request.quantidade());
        return new ResponseEntity<>(Resposta.criar(new CadastroCarrinhoResponse(carrinho)), HttpStatus.CREATED);
    }

}
