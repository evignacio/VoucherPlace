package org.techchallenge.vendas.domain.entity.factory;

import org.techchallenge.vendas.domain.entity.Produto;

import java.math.BigDecimal;

public abstract class ProdutoFactory {

    private ProdutoFactory() {

    }

    public static Produto criar(String nome, String sku, String fabricante, BigDecimal preco) {
        return new Produto(nome, sku, fabricante, preco);
    }
}
