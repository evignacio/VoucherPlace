package org.techchallenge.vendas.domain.repository;

import org.techchallenge.vendas.domain.entity.Estoque;

import java.util.List;

public interface EstoqueRepository {
    Estoque salvar(Estoque Estoque);

    Estoque buscar(String sku);

    List<Estoque> listar();
}
