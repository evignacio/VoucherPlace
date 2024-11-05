package org.techchallenge.checkout.domain.repository;

import org.techchallenge.checkout.domain.entity.Pedido;

import java.util.Optional;

public interface PedidoRepository {
    Optional<Pedido> consultar(long idPedido);
    Pedido salvar(Pedido pedido);
}
