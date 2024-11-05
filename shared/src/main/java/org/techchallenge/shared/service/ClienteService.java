package org.techchallenge.shared.service;

import org.techchallenge.shared.dto.ClienteDTO;

public interface ClienteService {

    ClienteDTO consultar(long idCliente);

    boolean exite(String cpf);

    boolean exite(long IdCliente);
}
