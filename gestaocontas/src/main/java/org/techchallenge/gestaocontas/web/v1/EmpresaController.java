package org.techchallenge.gestaocontas.web.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techchallenge.gestaocontas.application.service.CadastroEmpresaService;
import org.techchallenge.gestaocontas.web.v1.request.CadastroEmpresaRequest;

@RestController
@RequestMapping("/empresa")
@RequiredArgsConstructor
public class EmpresaController {

    private final CadastroEmpresaService cadastroEmpresaService;

    @PostMapping
    public ResponseEntity<Void> listar(@RequestBody CadastroEmpresaRequest request) {
        this.cadastroEmpresaService.cadastrar(request.emailAcesso(), request.cnpj(), request.contato());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
