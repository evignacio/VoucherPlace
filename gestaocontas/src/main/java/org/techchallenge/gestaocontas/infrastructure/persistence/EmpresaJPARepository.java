package org.techchallenge.gestaocontas.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.techchallenge.gestaocontas.domain.entity.Empresa;

@Component
public interface EmpresaJPARepository extends JpaRepository<Empresa, String> {
}
