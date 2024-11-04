package org.techchallenge.resource.v1.vendas.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CadastroProdutoRequest(
        @Size(min = 4, max = 20, message = "deve ter etre 4 e 20 caracteres") String nome,
        @Size(min = 6, message = "deve ter 6 caracteres") String sku,
        @NotNull Long idEmpresa,
        @Size(max = 100, message = "deve ter ate 100 caracteres") String descricao,
        @Size(max = 100, message = "deve ter ate 100 caracteres") String fabricante,
        @DecimalMin(value = "0.01", inclusive = false)
        @Digits(integer = 5, fraction = 2) BigDecimal preco) {
}
