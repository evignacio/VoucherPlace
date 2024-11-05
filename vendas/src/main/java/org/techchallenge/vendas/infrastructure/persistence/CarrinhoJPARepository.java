package org.techchallenge.vendas.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.techchallenge.vendas.domain.entity.Carrinho;
import org.techchallenge.vendas.domain.entity.Estoque;

import java.util.Optional;

@Component
public interface CarrinhoJPARepository extends JpaRepository<Carrinho, String> {
}
