package org.techchallenge.resource.v1.vendas.request;

import jakarta.validation.constraints.Size;

public record CadastroEstoqueProdutoRequest(
        @Size(min = 6, max = 6, message = "deve ter 6 caracteres") String sku,
        int quantidade) {
}
