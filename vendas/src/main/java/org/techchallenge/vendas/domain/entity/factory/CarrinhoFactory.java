package org.techchallenge.vendas.domain.entity.factory;

import org.techchallenge.vendas.domain.entity.Carrinho;
import org.techchallenge.vendas.domain.entity.Produto;
import org.techchallenge.vendas.domain.entity.ProdutoCarrinho;

import java.util.List;
import java.util.UUID;

public abstract class CarrinhoFactory {

    private CarrinhoFactory() {

    }

    public static Carrinho criar(Produto produto, int quantidadeProduto) {
        var produtoCarrinho = new ProdutoCarrinho(produto, quantidadeProduto);
        return new Carrinho(List.of(produtoCarrinho));
    }
}
