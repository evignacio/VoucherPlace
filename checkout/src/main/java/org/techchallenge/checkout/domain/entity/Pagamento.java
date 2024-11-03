package org.techchallenge.checkout.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 2152152422441766993L;
    @Id
    @Column(name = "id", nullable = false)
    private String id;
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

    public Pagamento(Pedido pedido, BigDecimal valor, MetodoPagamento metodoPagamento, int quantidadeParcelas, LocalDate dataPagamento) {
        this.id = UUID.randomUUID().toString();
        this.pedido = pedido;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
        this.quantidadeParcelas = quantidadeParcelas;
        this.dataPagamento = dataPagamento;
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
