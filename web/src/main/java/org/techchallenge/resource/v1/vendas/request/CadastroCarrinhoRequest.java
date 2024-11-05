package org.techchallenge.resource.v1.vendas.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record CadastroCarrinhoRequest(
        @Size(min = 6, message = "deve ter 6 caracteres") String sku,
        @Min(1) int quantidade
) {
}