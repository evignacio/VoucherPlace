package org.techchallenge.gestaocontas.domain.repository;

import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.valueobject.Cpf;

import java.util.Optional;

public interface ClienteRepository {
    Optional<Cliente> consultar(long id);

    Optional<Cliente> consultar(Cpf cpf);

    Cliente salvar(Cliente cliente);
}
