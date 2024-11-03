package org.techchallenge.resource.v1.vendas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.techchallenge.resource.v1.response.Resposta;
import org.techchallenge.vendas.application.service.BuscaCategoriasService;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class BuscaCategoriasController {

    private final BuscaCategoriasService buscaCategoriasService;

    @GetMapping
    public ResponseEntity<Resposta> buscar(@RequestParam(required = false) String sku, @RequestParam(required = false) String titulo) {
        var categorias = this.buscaCategoriasService.buscar(titulo, sku);
        return new ResponseEntity<>(Resposta.criar(categorias), HttpStatus.OK);
    }

}
