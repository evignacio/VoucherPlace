package org.techchallenge.gestaocontas.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.repository.EmpresaRepository;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;


@Service
@RequiredArgsConstructor
public class ConsultarEmpresaService {

    private final EmpresaRepository empresaRepository;

    public boolean cadastroJaRealizado(Cnpj cnpj) {
        return this.empresaRepository.consultar(cnpj)
                .isPresent();
    }
}
