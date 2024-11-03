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
import org.techchallenge.resource.v1.vendas.request.CadastroCategoriaRequest;
import org.techchallenge.vendas.application.service.CadastroCategoriaService;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CadastroCategoriaController {

    private final CadastroCategoriaService cadastroCategoriaService;

    @PostMapping
    public ResponseEntity<Resposta> cadastrar(@RequestBody @Valid CadastroCategoriaRequest request) {
        this.cadastroCategoriaService.cadastrar(request.titulo());
        return new ResponseEntity<>(Resposta.criar(), HttpStatus.CREATED);
    }

}
