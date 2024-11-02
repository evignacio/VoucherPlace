package org.techchallenge.gestaocontas.domain.repository;

import org.techchallenge.gestaocontas.domain.entity.Cliente;

public interface ClienteRepository {
    Cliente salvar(Cliente cliente);
}
