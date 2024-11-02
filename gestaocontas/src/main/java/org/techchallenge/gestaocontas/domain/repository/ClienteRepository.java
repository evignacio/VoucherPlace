package org.techchallenge.gestaocontas.domain.repository;

import org.techchallenge.gestaocontas.domain.entity.Cliente;

import java.util.Optional;

public interface ClienteRepository {
    Optional<Cliente> consultar(long id);

    Cliente salvar(Cliente cliente);
}
