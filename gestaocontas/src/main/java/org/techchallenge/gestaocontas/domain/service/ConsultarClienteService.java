package org.techchallenge.gestaocontas.domain.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.repository.ClienteRepository;
import org.techchallenge.gestaocontas.domain.exception.ApplicationException;

@Service
@RequiredArgsConstructor
public class ConsultarClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente consultar(long idCliente) {
        return this.clienteRepository.consultar(idCliente)
                .orElseThrow(() -> ApplicationException.buildBusinessException("Cliente nao encontrado"));
    }
}
