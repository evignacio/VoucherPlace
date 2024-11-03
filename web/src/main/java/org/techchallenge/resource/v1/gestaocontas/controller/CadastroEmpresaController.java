package org.techchallenge.resource.v1.gestaocontas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techchallenge.gestaocontas.application.service.CadastroEmpresaService;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;
import org.techchallenge.gestaocontas.domain.valueobject.Contato;
import org.techchallenge.gestaocontas.domain.valueobject.Email;
import org.techchallenge.gestaocontas.domain.valueobject.Telefone;
import org.techchallenge.resource.v1.gestaocontas.request.CadastroEmpresaRequest;
import org.techchallenge.resource.v1.Resposta;
import org.techchallenge.resource.v1.gestaocontas.response.CadastroEmpresaResponse;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class CadastroEmpresaController {

    private final CadastroEmpresaService cadastroEmpresaService;

    @PostMapping
    public ResponseEntity<Resposta<CadastroEmpresaResponse>> cadastrar(@RequestBody @Valid CadastroEmpresaRequest request) {
        long idEmpresa = this.cadastroEmpresaService.cadastrar(this.toCnpj(request), this.toEmail(request), this.toContato(request));
        return new ResponseEntity<>(Resposta.criar(new CadastroEmpresaResponse(idEmpresa)), HttpStatus.CREATED);
    }

    private Cnpj toCnpj(CadastroEmpresaRequest request) {
        return new Cnpj(request.cnpj());
    }

    private Email toEmail(CadastroEmpresaRequest request) {
        return new Email(request.emailAcesso());
    }

    private Contato toContato(CadastroEmpresaRequest request) {
        var emailContato = new Email(request.emailContato());
        var telefone = new Telefone(request.telefone().ddd(), request.telefone().numero());
        return new Contato(telefone, emailContato);
    }
}
