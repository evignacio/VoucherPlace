package org.techchallenge.vendas.domain.repository;

import org.techchallenge.vendas.domain.entity.Produto;

public interface ProdutoRepository {
    Produto salvar(Produto produto);
    Produto buscar(String sku);
}
