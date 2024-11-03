package org.techchallenge.resource.v1.vendas.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public record CadastroProdutoRequest(
        @Size(min = 4, max = 20, message = "deve ter etre 4 e 20 caracteres") String nome,
        @Size(min = 6, max = 6, message = "deve ter 6 caracteres") String sku,
        @Size(max = 100, message = "deve ter ate 100 caracteres") String descricao,
        @Size(max = 100, message = "deve ter ate 100 caracteres") String fabricante,
        @DecimalMin(value = "0.01", inclusive = false)
        @Digits(integer = 5, fraction = 2)BigDecimal preco,
        @Nullable
        List<String> categorias) {
}
