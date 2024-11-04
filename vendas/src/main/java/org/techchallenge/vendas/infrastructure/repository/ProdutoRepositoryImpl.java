package org.techchallenge.vendas.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.vendas.domain.entity.Produto;
import org.techchallenge.vendas.domain.repository.ProdutoRepository;
import org.techchallenge.vendas.infrastructure.persistence.ProdutoJPARepository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProdutoRepositoryImpl implements ProdutoRepository {
    private final ProdutoJPARepository produtoJPARepository;

    @Override
    public Produto salvar(Produto produto) {
        return this.produtoJPARepository.save(produto);
    }

    @Override
    public Optional<Produto> buscar(String sku) {
        return produtoJPARepository.findBySku(sku);
    }

    @Override
    public List<Produto> buscar(List<String> skus) {
        return produtoJPARepository.findBySkuIn(skus);
    }
}
