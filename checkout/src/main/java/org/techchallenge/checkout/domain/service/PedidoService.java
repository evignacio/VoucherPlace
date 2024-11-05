package org.techchallenge.checkout.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.checkout.domain.entity.Pedido;
import org.techchallenge.checkout.domain.repository.PedidoRepository;
import org.techchallenge.shared.exception.ApplicationException;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public Pedido consultar(Long idPedido) {
        return this.pedidoRepository.consultar(idPedido)
                .orElseThrow(() -> ApplicationException.buildBusinessException("Pedido nao encontrado"));
    }

    public Pedido salvar(Pedido pedido) {
        return this.pedidoRepository.salvar(pedido);
    }
}
