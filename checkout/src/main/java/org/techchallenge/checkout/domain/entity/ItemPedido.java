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
    @Column(name = "valor_unitario", nullable = false)
    private BigDecimal valorUnitario;
    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    public ItemPedido(String sku, Integer quantidade, BigDecimal valorUnitario) {
        this.sku = sku;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.calcularValorTotal();
    }

    private void calcularValorTotal() {
        this.valorTotal = valorUnitario.multiply(new BigDecimal(quantidade));
    }
}
