package org.techchallenge.resource.v1.vendas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techchallenge.resource.v1.response.Resposta;
import org.techchallenge.vendas.application.service.VinculoProdutoCategoriaService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class VincularProdutoCategoriaController {

    private final VinculoProdutoCategoriaService vinculoProdutoCategoriaService;

    @PostMapping("/categorias/{categoria}")
    public ResponseEntity<Resposta> cadastrar(@RequestBody List<String> skusProdutos, @PathVariable String categoria) {
        this.vinculoProdutoCategoriaService.vincular(skusProdutos, categoria);
        return new ResponseEntity<>(Resposta.criar(), HttpStatus.CREATED);
    }

}
