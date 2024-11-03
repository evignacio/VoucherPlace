package org.techchallenge.vendas.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.techchallenge.vendas.domain.entity.Estoque;
import org.techchallenge.vendas.domain.entity.Produto;

import java.util.Optional;

@Component
public interface EstoqueJPARepository extends JpaRepository<Estoque, String> {
    Optional<Estoque> findByProdutoSku(String sku);
}
