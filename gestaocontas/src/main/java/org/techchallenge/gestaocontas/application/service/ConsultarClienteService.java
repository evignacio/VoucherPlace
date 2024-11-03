package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.common.dto.ClienteDTO;
import org.techchallenge.gestaocontas.domain.service.ClienteServiceImpl;

@Service
@RequiredArgsConstructor
public class ConsultarClienteService {

    private final ClienteServiceImpl clienteService;

    public ClienteDTO consultar(long idCliente) {
        return this.clienteService.consultar(idCliente);
    }
}
