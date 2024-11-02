package org.techchallenge.gestaocontas.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.gestaocontas.domain.entity.Empresa;
import org.techchallenge.gestaocontas.domain.repository.EmpresaRepository;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;
import org.techchallenge.gestaocontas.infrastructure.persistence.EmpresaJPARepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmpresaRepositoryImpl implements EmpresaRepository {
    private final EmpresaJPARepository empresaJPARepository;

    @Override
    public Optional<Empresa> consultar(Cnpj cnpj) {
        return this.empresaJPARepository.findByCnpj(cnpj);
    }

    @Override
    public Empresa salvar(Empresa empresa) {
        return this.empresaJPARepository.save(empresa);
    }
}
