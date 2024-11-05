package org.techchallenge.resource.v1.gestaocontas.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techchallenge.shared.dto.EmpresaDTO;
import org.techchallenge.gestaocontas.application.service.ConsultarEmpresaService;
import org.techchallenge.resource.v1.Resposta;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class ConsultarEmpresaController {

    private final ConsultarEmpresaService consultarEmpresaService;

    @GetMapping("{idEmpresa}")
    public ResponseEntity<Resposta<EmpresaDTO>> consultar(@PathVariable Long idEmpresa) {
        var empresa = this.consultarEmpresaService.consultar(idEmpresa);
        return new ResponseEntity<>(Resposta.criar(empresa), HttpStatus.OK);
    }
}
