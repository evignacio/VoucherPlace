package org.techchallenge.resource.v1.checkout.request;

import java.math.BigDecimal;

public record ItemPedidoRequest(String sku, int quantidade, BigDecimal valor) {
}
