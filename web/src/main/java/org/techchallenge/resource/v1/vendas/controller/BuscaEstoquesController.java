package org.techchallenge.resource.v1.vendas.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techchallenge.resource.v1.response.Resposta;
import org.techchallenge.vendas.application.service.BuscarEstoquesService;

@RestController
@RequestMapping("/estoques")
@RequiredArgsConstructor
@Tag(name = "Estoque")
public class BuscaEstoquesController {

    private final BuscarEstoquesService buscarEstoquesService;

    @GetMapping()
    public ResponseEntity<Resposta> cadastrar() {
        var estoques = this.buscarEstoquesService.buscar();
        return new ResponseEntity<>(Resposta.criar(estoques), HttpStatus.OK);
    }

}
