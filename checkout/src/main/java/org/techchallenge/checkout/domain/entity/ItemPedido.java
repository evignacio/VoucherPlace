package org.techchallenge.checkout.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class ItemPedido {
    @Column(name = "sku", nullable = false)
    private String sku;
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;
}
