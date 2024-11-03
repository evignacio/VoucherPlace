package org.techchallenge.checkout.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techchallenge.checkout.domain.entity.Pedido;

public interface PedidoJPARepository extends JpaRepository<Pedido, String> {
}
