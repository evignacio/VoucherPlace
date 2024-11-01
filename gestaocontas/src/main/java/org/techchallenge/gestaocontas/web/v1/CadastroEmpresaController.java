package org.techchallenge.gestaocontas.web.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techchallenge.gestaocontas.application.service.CadastroEmpresaService;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;
import org.techchallenge.gestaocontas.domain.valueobject.Contato;
import org.techchallenge.gestaocontas.domain.valueobject.Email;
import org.techchallenge.gestaocontas.domain.valueobject.Telefone;
import org.techchallenge.gestaocontas.web.v1.request.CadastroEmpresaRequest;
import org.techchallenge.gestaocontas.web.v1.response.Response;

@RestController
@RequestMapping("/empresa")
@RequiredArgsConstructor
public class CadastroEmpresaController {

    private final CadastroEmpresaService cadastroEmpresaService;

    @PostMapping
    public ResponseEntity<Response> cadastrar(@RequestBody CadastroEmpresaRequest request) {
        this.cadastroEmpresaService.cadastrar(this.obterCnpj(request), this.obterEmailAcesso(request), this.obterContato(request));
        return new ResponseEntity<>(Response.sucesso(), HttpStatus.CREATED);
    }

    private Cnpj obterCnpj(CadastroEmpresaRequest request) {
        return new Cnpj(request.cnpj());
    }

    private Email obterEmailAcesso(CadastroEmpresaRequest request) {
        return new Email(request.emailAcesso());
    }

    private Contato obterContato(CadastroEmpresaRequest request) {
        var emailContato = new Email(request.emailContato());
        var telefone = new Telefone(request.telefone());
        return new Contato(telefone, emailContato);
    }
}
