package org.techchallenge.gestaocontas.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.techchallenge.gestaocontas.domain.entity.Empresa;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;

import java.util.Optional;

@Component
public interface EmpresaJPARepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findByCnpj(Cnpj cnpj);
}
