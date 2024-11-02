package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.repository.ClienteRepository;

@Service
@RequiredArgsConstructor
public class CadastroClienteService {

    private final ClienteRepository clienteRepository;

    public void cadastrar(Cliente cliente) {
        this.clienteRepository.salvar(cliente);
    }
}
