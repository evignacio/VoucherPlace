package org.techchallenge.vendas.domain.entity.factory;

import org.techchallenge.vendas.domain.entity.Categoria;

public abstract class CategoriaFactory {

    private CategoriaFactory() {

    }

    public static Categoria criar(String titulo) {
        return new Categoria(titulo);
    }
}
