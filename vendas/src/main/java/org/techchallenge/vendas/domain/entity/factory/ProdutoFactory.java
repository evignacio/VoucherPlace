package org.techchallenge.vendas.domain.entity.factory;

import org.techchallenge.vendas.domain.entity.Categoria;
import org.techchallenge.vendas.domain.entity.Produto;

import java.math.BigDecimal;
import java.util.List;

public abstract class ProdutoFactory {

    private ProdutoFactory() {

    }

    public static Produto criar(String nome, String sku, String fabricante, BigDecimal preco, List<String> categorias) {
        var cat = categorias.stream().map(Categoria::new).toList();
        return new Produto(sku, nome, fabricante, preco, null, cat);
    }
}
