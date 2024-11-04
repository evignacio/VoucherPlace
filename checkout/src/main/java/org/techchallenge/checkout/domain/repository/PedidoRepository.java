package org.techchallenge.checkout.domain.repository;

import org.techchallenge.checkout.domain.entity.Pedido;

public interface PedidoRepository {
    Pedido salvar(Pedido pedido);
}
