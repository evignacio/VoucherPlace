package org.techchallenge.vendas.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Estoque implements Serializable {

    private static final long serialVersionUID = -6602733079927740217L;
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_sku", referencedColumnName = "sku")
    private Produto produto;
    @Column(name = "quantidadeProduto")
    int quantidadeProduto;
    @Column(name = "ativo")
    boolean ativo = false;

    public Estoque(Produto produto, int quantidadeProduto, boolean ativo) {
        this.produto = produto;
        this.quantidadeProduto = quantidadeProduto;
        this.ativo = ativo;
    }
}
