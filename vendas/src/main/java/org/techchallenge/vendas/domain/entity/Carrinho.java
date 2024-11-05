package org.techchallenge.vendas.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Carrinho implements Serializable {

    private static final long serialVersionUID = -6602733079927740217L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<ProdutoCarrinho> produtos;


    public Carrinho(List<ProdutoCarrinho> produtos) {
        this.produtos = produtos;
        calcularValorTotal(produtos);
    }

    // Para um unico sku
    private void calcularValorTotal(List<ProdutoCarrinho> produtos) {
        var preco = produtos.stream().map(ProdutoCarrinho::getPreco).reduce(BigDecimal.ZERO, BigDecimal::add);
        var totalProdutos = produtos.stream().map(ProdutoCarrinho::getQuantidade).reduce(0, Integer::sum);
        this.valorTotal = preco.multiply(BigDecimal.valueOf(totalProdutos));
    }
}
