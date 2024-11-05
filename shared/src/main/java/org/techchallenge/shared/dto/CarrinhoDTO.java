package org.techchallenge.shared.dto;


import java.math.BigDecimal;
import java.util.UUID;

public record CarrinhoDTO(
        UUID id,
        BigDecimal valorTotal) {
}
