package org.techchallenge.vendas.domain.repository;

import org.techchallenge.vendas.domain.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    Produto salvar(Produto produto);
    Optional<Produto> buscar(String sku);
    List<Produto> buscar(List<String> skus);
}
