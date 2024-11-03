package org.techchallenge.resource.v1.checkout.request;

import java.util.Set;

public record CriarPedidoRequest(
        long idEmpresa,
        long idCliente,
        Set<ItemPedidoRequest> itensPedido,
        EnderecoRequest endereco
) {
}
