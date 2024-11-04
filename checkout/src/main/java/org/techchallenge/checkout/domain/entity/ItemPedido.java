package org.techchallenge.checkout.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.common.exception.ApplicationException;

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

    public ItemPedido(@NotNull String sku, @NotNull Integer quantidade, @NotNull BigDecimal valorUnitario) {
        this.sku = sku;
        this.setQuantidade(quantidade);
        this.setValorUnitario(valorUnitario);
        this.calcularValorTotal();
    }

    private void setQuantidade(@NotNull Integer quantidade) {
        if (quantidade < 0)
            throw ApplicationException.buildValidationException("Quantidade deve ser maior que zero");


        this.quantidade = quantidade;
    }

    private void setValorUnitario(@NotNull BigDecimal valorUnitario) {
        if (valorUnitario.compareTo(BigDecimal.ZERO) < 0)
            throw ApplicationException.buildValidationException("Valor de unitario deve ser maior que zero");

        this.valorUnitario = valorUnitario;
    }

    private void calcularValorTotal() {
        this.valorTotal = valorUnitario.multiply(new BigDecimal(quantidade));
    }
}
