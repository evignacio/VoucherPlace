package org.techchallenge.vendas.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.vendas.domain.entity.ProdutoCarrinho;
import org.techchallenge.vendas.domain.repository.ProdutoCarrinhoRepository;
import org.techchallenge.vendas.infrastructure.persistence.ProdutoCarrinhoJPARepository;


@Repository
@RequiredArgsConstructor
public class ProdutoCarrinhoRepositoryImpl implements ProdutoCarrinhoRepository {
    private final ProdutoCarrinhoJPARepository produtoJPARepository;

    @Override
    public ProdutoCarrinho salvar(ProdutoCarrinho produto) {
        return produtoJPARepository.save(produto);
    }
}
