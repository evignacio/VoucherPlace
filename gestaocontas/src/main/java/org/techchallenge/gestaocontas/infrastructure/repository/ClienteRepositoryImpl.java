package org.techchallenge.gestaocontas.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.repository.ClienteRepository;
import org.techchallenge.gestaocontas.infrastructure.persistence.ClienteJPARepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteJPARepository clienteJPARepository;

    @Override
    public Optional<Cliente> consultar(long idCliente) {
        return this.clienteJPARepository.findById(idCliente);
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return this.clienteJPARepository.save(cliente);
    }
}
