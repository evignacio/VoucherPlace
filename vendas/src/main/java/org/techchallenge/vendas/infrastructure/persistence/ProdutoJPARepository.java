package org.techchallenge.vendas.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.techchallenge.vendas.domain.entity.Produto;

@Component
public interface ProdutoJPARepository extends JpaRepository<Produto, String> {
}
