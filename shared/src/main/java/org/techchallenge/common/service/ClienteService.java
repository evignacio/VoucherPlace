package org.techchallenge.common.service;

import org.techchallenge.common.dto.ClienteDTO;

public interface ClienteService {

    ClienteDTO consultar(long idCliente);

    boolean exite(String cpf);

    boolean exite(long IdCliente);
}
