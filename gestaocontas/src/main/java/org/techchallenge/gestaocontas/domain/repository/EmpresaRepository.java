package org.techchallenge.gestaocontas.domain.repository;

import org.techchallenge.gestaocontas.domain.entity.Empresa;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;

import java.util.Optional;

public interface EmpresaRepository {
    Optional<Empresa> consultar(long idEmrpesa);

    Optional<Empresa> consultar(Cnpj cnpj);

    Empresa salvar(Empresa empresa);
}
