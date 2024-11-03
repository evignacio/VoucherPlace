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
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Pedido implements Serializable {
    private static final long serialVersionUID = -3481104978911282167L;
    @Id
    @Column(name = "id", nullable = false)
    private String id;
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

    public Pedido(BigDecimal valorTotal, BigDecimal valorTotalComDesconto, Set<ItemPedido> itens, Endereco endereco, Pagamento pagamaneto) {
        this.id = UUID.randomUUID().toString();
        this.valorTotal = valorTotal;
        this.valorTotalComDesconto = valorTotalComDesconto;
        this.itens = itens;
        this.endereco = endereco;
        this.pagamaneto = pagamaneto;
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
