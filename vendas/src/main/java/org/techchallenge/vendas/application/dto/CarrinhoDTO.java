package org.techchallenge.vendas.application.dto;


import java.math.BigDecimal;
import java.util.UUID;

public record CarrinhoDTO(
        UUID id,
        BigDecimal valorTotal) {
}
