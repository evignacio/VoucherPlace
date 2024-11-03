package org.techchallenge.gestaocontas.domain.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.techchallenge.common.exception.ApplicationException;
import org.techchallenge.gestaocontas.domain.entity.Empresa;
import org.techchallenge.gestaocontas.domain.repository.EmpresaRepository;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;


@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public Empresa consultar(long idEmpresa) {
        return this.empresaRepository.consultar(idEmpresa)
                .orElseThrow(() -> ApplicationException.buildBusinessException("Empresa nao encontrada"));
    }

    public boolean cadastroJaRealizado(Cnpj cnpj) {
        return this.empresaRepository.consultar(cnpj)
                .isPresent();
    }
}
