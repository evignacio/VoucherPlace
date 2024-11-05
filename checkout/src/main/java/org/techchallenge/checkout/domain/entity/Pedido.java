package org.techchallenge.checkout.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.checkout.domain.valueobject.Endereco;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Pedido implements Serializable {
    private static final long serialVersionUID = -3481104978911282167L;
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "idEmpresa", nullable = false)
    private long idEmpresa;
    @Column(name = "idCliente", nullable = false)
    private long idCliente;
    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;
    @Column(name = "valor_total_com_desconto")
    private BigDecimal valorTotalComDesconto;
    @ElementCollection
    @CollectionTable(name = "item_pedido", joinColumns = @JoinColumn(name = "pedido_id"))
    private Set<ItemPedido> itens = new HashSet<>();
    @Embedded
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamaneto;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPedido status;

    public Pedido(long idEmpresa, long idCliente, Set<ItemPedido> itens, Endereco endereco) {
        this.idEmpresa = idEmpresa;
        this.idCliente = idCliente;
        this.itens = itens;
        this.calculaValorTotal();
        this.endereco = endereco;
        this.status = StatusPedido.EM_ABERTO;
    }

    public void efetuarPagamento(MetodoPagamento metodoPagamento, int qtdParcelas) {
        final BigDecimal taxaDeDesconto = BigDecimal.valueOf(0.2);
        if (MetodoPagamento.VOUCHER.equals(metodoPagamento)) {
            BigDecimal valorDesconto = this.getValorTotal().multiply(taxaDeDesconto);
            this.valorTotalComDesconto = this.getValorTotal().subtract(valorDesconto);
        }
        this.pagamaneto = new Pagamento(this, this.valorTotalComDesconto, metodoPagamento, qtdParcelas);
        this.status = StatusPedido.CONCLUIDO;
    }

    private void calculaValorTotal() {
        this.valorTotal = this.itens.stream()
                .map(ItemPedido::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido pedido)) return false;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
