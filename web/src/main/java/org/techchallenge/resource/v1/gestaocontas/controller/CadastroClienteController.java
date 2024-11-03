package org.techchallenge.resource.v1.gestaocontas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techchallenge.gestaocontas.application.service.CadastroClienteService;
import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.valueobject.Cpf;
import org.techchallenge.gestaocontas.domain.valueobject.Email;
import org.techchallenge.gestaocontas.domain.valueobject.Telefone;
import org.techchallenge.resource.v1.Resposta;
import org.techchallenge.resource.v1.gestaocontas.request.CadastroClienteRequest;
import org.techchallenge.resource.v1.gestaocontas.response.CadastroClienteResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class CadastroClienteController {

    private final CadastroClienteService cadastroClienteService;

    @PostMapping
    public ResponseEntity<Resposta<CadastroClienteResponse>> cadastrar(@Valid @RequestBody CadastroClienteRequest request) {
        long idCliente = this.cadastroClienteService.cadastrar(this.toCliente(request));
        return new ResponseEntity<>(Resposta.criar(new CadastroClienteResponse(idCliente)), HttpStatus.CREATED);
    }

    private Cliente toCliente(CadastroClienteRequest request) {
        return new Cliente(
                new Email(request.emailAcesso()),
                request.senhaAcesso(),
                request.nome(),
                request.sobreNome(),
                new Cpf(request.cpf()),
                request.dataNascimento(),
                new Telefone(request.telefone().ddd(), request.telefone().numero())
        );
    }
}
