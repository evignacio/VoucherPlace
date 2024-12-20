package org.techchallenge.gestaocontas.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.valueobject.Cpf;

import java.util.Optional;

@Component
public interface ClienteJPARepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(Cpf cpf);
}
