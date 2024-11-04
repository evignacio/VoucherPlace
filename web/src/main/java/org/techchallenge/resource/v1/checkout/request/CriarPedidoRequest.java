package org.techchallenge.resource.v1.checkout.request;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record CriarPedidoRequest(
        @NotNull long idEmpresa,
        @NotNull long idCliente,
        @NotNull Set<ItemPedidoRequest> itensPedido,
        @NotNull EnderecoRequest endereco
) {
}
