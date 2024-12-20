package org.techchallenge.vendas.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.techchallenge.vendas.domain.entity.Produto;

import java.util.List;
import java.util.Optional;

@Component
public interface ProdutoJPARepository extends JpaRepository<Produto, String> {
    Optional<Produto> findBySku(String sku);
    List<Produto> findBySkuIn(List<String> sku);
}
