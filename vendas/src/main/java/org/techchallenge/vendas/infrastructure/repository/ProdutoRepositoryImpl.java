package org.techchallenge.vendas.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.vendas.domain.entity.Produto;
import org.techchallenge.vendas.domain.repository.ProdutoRepository;
import org.techchallenge.vendas.infrastructure.persistence.ProdutoJPARepository;

import java.util.List;

import static org.techchallenge.common.exception.ApplicationException.buildBusinessException;

@Repository
@RequiredArgsConstructor
public class ProdutoRepositoryImpl implements ProdutoRepository {
    private final ProdutoJPARepository produtoJPARepository;

    @Override
    public Produto salvar(Produto produto) {
        return this.produtoJPARepository.save(produto);
    }

    @Override
    public Produto buscar(String sku) {
        var ex = buildBusinessException("Produto nao existente com sku: " + sku);
        return produtoJPARepository.findBySku(sku).orElseThrow(() -> ex);
    }

    @Override
    public List<Produto> buscar(List<String> skus) {
        return produtoJPARepository.findBySkuIn(skus);
    }
}
