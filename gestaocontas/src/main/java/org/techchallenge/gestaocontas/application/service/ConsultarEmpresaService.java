package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.shared.dto.EmpresaDTO;
import org.techchallenge.gestaocontas.domain.service.EmpresaServiceImpl;

@Service
@RequiredArgsConstructor
public class ConsultarEmpresaService {

    private final EmpresaServiceImpl empresaService;

    public EmpresaDTO consultar(long idEmpresa) {
        return this.empresaService.consultar(idEmpresa);
    }
}
