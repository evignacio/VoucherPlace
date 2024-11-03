package org.techchallenge.vendas.application.dto;


import org.techchallenge.vendas.domain.entity.Estoque;

public record EstoqueDTO(
        String nomeProduto,
        String skuProduto,
        int quantidadeProduto,
        boolean ativo
) {
    public static EstoqueDTO from(Estoque estoque) {
        return new EstoqueDTO(estoque.getProduto().getNome(), estoque.getProduto().getSku(), estoque.getQuantidadeProduto(), estoque.isAtivo());
    }
}
