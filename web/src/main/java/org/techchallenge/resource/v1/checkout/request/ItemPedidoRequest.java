package org.techchallenge.resource.v1.checkout.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ItemPedidoRequest(
        @NotNull String sku,
        @NotNull int quantidade, BigDecimal valor) {
}
