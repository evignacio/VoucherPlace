package org.techchallenge.vendas.domain.entity.factory;

import org.techchallenge.vendas.domain.entity.Produto;

import java.math.BigDecimal;

public abstract class ProdutoFactory {

    private ProdutoFactory() {

    }

    public static Produto criar(String nome, String sku, Long idEmpresa, String fabricante, BigDecimal preco) {
        return new Produto(sku, idEmpresa, nome, fabricante, preco);
    }
}
