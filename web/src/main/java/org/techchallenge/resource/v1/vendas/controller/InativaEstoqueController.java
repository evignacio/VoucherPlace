package org.techchallenge.resource.v1.vendas.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techchallenge.resource.v1.response.Resposta;
import org.techchallenge.vendas.application.service.AtivarEstoqueService;

@RestController
@RequestMapping("/estoques")
@RequiredArgsConstructor
@Tag(name = "Estoque")
public class InativaEstoqueController {

    private final AtivarEstoqueService ativarEstoqueService;

    //TODO: implementar validacao de empresa para esse fluxo
    @PatchMapping("/{sku}/inativar")
    public ResponseEntity<Resposta> inativar(@PathVariable @NotBlank String sku) {
        var estoque = this.ativarEstoqueService.ativar(sku);
        return new ResponseEntity<>(Resposta.criar(estoque), HttpStatus.OK);
    }

}
