package org.techchallenge.vendas.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.vendas.domain.entity.Estoque;
import org.techchallenge.vendas.domain.repository.EstoqueRepository;
import org.techchallenge.vendas.infrastructure.persistence.EstoqueJPARepository;

import java.util.List;

import static org.techchallenge.common.exception.ApplicationException.buildBusinessException;


@Repository
@RequiredArgsConstructor
public class EstoqueRepositoryImpl implements EstoqueRepository {
    private final EstoqueJPARepository EstoqueJPARepository;

    @Override
    public Estoque salvar(Estoque estoque) {
        return this.EstoqueJPARepository.save(estoque);
    }

    @Override
    public Estoque buscar(String sku) {
        var ex = buildBusinessException("Estoque nao existente com sku: " + sku);
        return EstoqueJPARepository.findByProdutoSku(sku).orElseThrow(() -> ex);
    }

    @Override
    public List<Estoque> listar() {
        return EstoqueJPARepository.findAll();
    }
}
