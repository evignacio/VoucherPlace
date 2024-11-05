package org.techchallenge.vendas.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ProdutoCarrinho implements Serializable {

    private static final long serialVersionUID = -6602733079927740217L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "sku", nullable = false)
    private String sku;
    @Column(name = "nome")
    private String nome;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "preco")
    private BigDecimal preco;
    @ManyToOne
    private Carrinho carrinho;


    public ProdutoCarrinho(Produto produto, int quantidade) {
        this.sku = produto.getSku();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidade = quantidade;
    }


}
