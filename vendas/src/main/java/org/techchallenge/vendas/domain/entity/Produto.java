package org.techchallenge.vendas.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.vendas.domain.valueobject.Item;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends Item implements Serializable {

    private static final long serialVersionUID = -6602733079927740217L;
    @Column(name = "nome")
    String nome;
    @Column(name = "sku")
    String sku;
    @Column(name = "fabricante")
    String fabricante;
    @Column(name = "preco")
    BigDecimal preco;
    @Column(name = "ativo")
    boolean ativo = false;

    public Produto(String nome, String sku, String fabricante, BigDecimal preco) {
        this.nome = nome;
        this.sku = sku;
        this.fabricante = fabricante;
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return ativo == produto.ativo && Objects.equals(nome, produto.nome) && Objects.equals(sku, produto.sku) && Objects.equals(fabricante, produto.fabricante) && Objects.equals(preco, produto.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sku, fabricante, preco, ativo);
    }
}
