package org.techchallenge.resource.v1.gestaocontas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techchallenge.shared.dto.ClienteDTO;
import org.techchallenge.gestaocontas.application.service.ConsultarClienteService;
import org.techchallenge.resource.v1.Resposta;

@RestController
@RequiredArgsConstructor
@RequestMapping("clientes")
public class ConsultarClienteController {

    private final ConsultarClienteService consultarClienteService;

    @GetMapping("{idCliente}")
    public ResponseEntity<Resposta<ClienteDTO>> consultar(@PathVariable Long idCliente) {
        var cliente = this.consultarClienteService.consultar(idCliente);
        return new ResponseEntity<>(Resposta.criar(cliente), HttpStatus.OK);
    }
}
