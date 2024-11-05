package org.techchallenge.checkout.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.shared.exception.ApplicationException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 2152152422441766993L;
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @OneToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private Pedido pedido;
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;
    @Column(name = "metodo_pagamento", nullable = false)
    private MetodoPagamento metodoPagamento;
    @Column(name = "quantidade_parcelas", nullable = false)
    private int quantidadeParcelas;
    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;

    public Pagamento(@NotNull Pedido pedido, @NotNull BigDecimal valor, @NotNull MetodoPagamento metodoPagamento, @NotNull int quantidadeParcelas) {
        this.pedido = pedido;
        this.setValor(valor);
        this.metodoPagamento = metodoPagamento;
        this.quantidadeParcelas = quantidadeParcelas;
        this.dataPagamento = LocalDate.now();
    }

    public void setValor(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0)
            throw ApplicationException.buildValidationException("Valor pagamento deve ser maior que zero");

        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagamento pagamento)) return false;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
