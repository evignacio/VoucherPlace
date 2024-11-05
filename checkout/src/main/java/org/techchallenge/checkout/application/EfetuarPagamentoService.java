package org.techchallenge.checkout.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.checkout.domain.entity.MetodoPagamento;
import org.techchallenge.checkout.domain.repository.PagamentoRepository;
import org.techchallenge.checkout.domain.service.PedidoService;

import java.math.BigDecimal;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EfetuarPagamentoService {

    private final PedidoService pedidoService;
    private final PagamentoRepository pagamentoRepository;

    public String efetuarPagamento(long idPedido, MetodoPagamento metodoPagamento, int qtdParcelas, VoucherDTO voucherDTO) {
        var pedido = this.pedidoService.consultar(idPedido);
        BigDecimal valorPagamento = Objects.isNull(pedido.getValorTotalComDesconto()) ? pedido.getValorTotal() : pedido.getValorTotalComDesconto();
        var idTransacao = this.pagamentoRepository.efetuarPagamento(voucherDTO, valorPagamento);
        pedido.efetuarPagamento(metodoPagamento, qtdParcelas);
        this.pedidoService.salvar(pedido);

        return idTransacao;
    }
}
