package org.techchallenge.gestaocontas.domain.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.repository.ClienteRepository;
import org.techchallenge.common.exception.ApplicationException;
import org.techchallenge.gestaocontas.domain.valueobject.Cpf;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente consultar(long idCliente) {
        return this.clienteRepository.consultar(idCliente)
                .orElseThrow(() -> ApplicationException.buildBusinessException("Cliente nao encontrado"));
    }

    public boolean cadastroJaRealizado(Cpf cpf) {
        return this.clienteRepository.consultar(cpf)
                .isPresent();
    }
}
