package org.techchallenge.vendas.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.techchallenge.vendas.domain.valueobject.Item;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Produto extends Item implements Serializable {

    private static final long serialVersionUID = -6602733079927740217L;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sku")
    private String sku;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "preco")
    private BigDecimal preco;
    @OneToOne(mappedBy = "produto")
    private Estoque estoque;


}
