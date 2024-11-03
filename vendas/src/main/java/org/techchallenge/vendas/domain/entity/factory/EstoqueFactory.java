package org.techchallenge.vendas.domain.entity.factory;

import org.techchallenge.vendas.domain.entity.Estoque;
import org.techchallenge.vendas.domain.entity.Produto;

public abstract class EstoqueFactory {

    private EstoqueFactory() {

    }

    public static Estoque criar(Produto produto, int quantidade, boolean ativo) {
        return new Estoque(produto, quantidade, ativo);
    }
}
