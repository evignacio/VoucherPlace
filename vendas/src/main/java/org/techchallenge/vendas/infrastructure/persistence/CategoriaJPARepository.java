package org.techchallenge.vendas.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.techchallenge.vendas.domain.entity.Categoria;

import java.util.List;
import java.util.Optional;

@Component
public interface CategoriaJPARepository extends JpaRepository<Categoria, String> {

    Optional<Categoria> findByTitulo(String titulo);

    List<Categoria> findByProdutosSku(String sku);
}
