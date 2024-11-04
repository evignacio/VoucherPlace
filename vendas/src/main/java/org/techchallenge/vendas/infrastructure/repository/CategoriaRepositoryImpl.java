package org.techchallenge.vendas.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.vendas.domain.entity.Categoria;
import org.techchallenge.vendas.domain.repository.CategoriaRepository;
import org.techchallenge.vendas.infrastructure.persistence.CategoriaJPARepository;

import java.util.List;

import static org.techchallenge.vendas.domain.exception.ApplicationException.buildBusinessException;

@Repository
@RequiredArgsConstructor
public class CategoriaRepositoryImpl implements CategoriaRepository {
    private final CategoriaJPARepository categoriaJPARepository;

    @Override
    public void salvar(Categoria categoria) {
        this.categoriaJPARepository.save(categoria);
    }

    @Override
    public Categoria buscar(String titulo) {
        var ex = buildBusinessException("Categoria nao existente com titulo: " + titulo);
        return this.categoriaJPARepository.findByTitulo(titulo).orElseThrow(() -> ex);
    }

    @Override
    public List<Categoria> buscarPorSku(String sku) {
        return this.categoriaJPARepository.findByProdutosSku(sku);
    }

    @Override
    public List<Categoria> listar() {
        return this.categoriaJPARepository.findAll();
    }
}
