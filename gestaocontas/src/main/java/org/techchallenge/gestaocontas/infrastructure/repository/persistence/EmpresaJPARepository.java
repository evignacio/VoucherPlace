package org.techchallenge.gestaocontas.infrastructure.repository.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techchallenge.gestaocontas.domain.entity.Empresa;

public interface EmpresaJPARepository extends JpaRepository<Empresa, String> {
}
