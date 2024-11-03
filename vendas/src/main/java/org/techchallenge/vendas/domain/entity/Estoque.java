package org.techchallenge.vendas.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.techchallenge.vendas.domain.valueobject.EstoqueItens;

import java.io.Serializable;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Estoque extends EstoqueItens implements Serializable {

    private static final long serialVersionUID = -6602733079927740217L;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private Produto produto;
    @Column(name = "quantidadeProduto")
    int quantidadeProduto;
    @Column(name = "ativo")
    boolean ativo = false;

}
