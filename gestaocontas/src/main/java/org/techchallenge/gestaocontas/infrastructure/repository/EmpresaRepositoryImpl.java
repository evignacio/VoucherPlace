package org.techchallenge.gestaocontas.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.gestaocontas.domain.entity.Empresa;
import org.techchallenge.gestaocontas.domain.repository.EmpresaRepository;
import org.techchallenge.gestaocontas.infrastructure.persistence.EmpresaJPARepository;

@Repository
@RequiredArgsConstructor
public class EmpresaRepositoryImpl implements EmpresaRepository {
    private final EmpresaJPARepository empresaJPARepository;

    @Override
    public Empresa salvar(Empresa empresa) {
        return this.empresaJPARepository.save(empresa);
    }
}
