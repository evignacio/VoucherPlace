package org.techchallenge.vendas.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.shared.service.ProdutoService;
import org.techchallenge.vendas.domain.entity.Produto;
import org.techchallenge.vendas.domain.repository.ProdutoRepository;

import static org.techchallenge.shared.exception.ApplicationException.buildBusinessException;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public boolean existe(String sku) {
        return this.produtoRepository.buscar(sku).isPresent();
    }

    public Produto buscar(String sku) {
        var ex = buildBusinessException("Produto nao existente com sku: " + sku);
        return this.produtoRepository.buscar(sku).orElseThrow(() -> ex);
    }
}
