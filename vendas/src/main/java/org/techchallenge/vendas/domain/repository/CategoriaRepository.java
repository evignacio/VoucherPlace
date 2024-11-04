package org.techchallenge.vendas.domain.repository;

import org.techchallenge.vendas.domain.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    void salvar(Categoria categoria);

    Categoria buscar(String titulo);

    List<Categoria> buscarPorSku(String sku);

    List<Categoria> listar();
}
