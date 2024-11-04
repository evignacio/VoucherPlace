package org.techchallenge.checkout.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.checkout.domain.entity.Pedido;
import org.techchallenge.checkout.domain.repository.PedidoRepository;
import org.techchallenge.checkout.infrastructure.persistence.PedidoJPARepository;

@Repository
@RequiredArgsConstructor
public class PedidoRepositoryImpl implements PedidoRepository {

    private final PedidoJPARepository pedidoJPARepository;

    @Override
    public Pedido salvar(Pedido pedido) {
        return this.pedidoJPARepository.save(pedido);
    }
}
