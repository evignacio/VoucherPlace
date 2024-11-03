package org.techchallenge.vendas.application.dto;


import org.techchallenge.vendas.domain.entity.Categoria;
import org.techchallenge.vendas.domain.entity.Produto;

import java.util.List;

public record CategoriaDTO(
        String titulo,
        List<String> skuProdutos
) {
    public static CategoriaDTO from(Categoria categoria) {
        var skus = categoria.getProdutos().stream().map(Produto::getSku).toList();
        return new CategoriaDTO(categoria.getTitulo(), skus);
    }
}
