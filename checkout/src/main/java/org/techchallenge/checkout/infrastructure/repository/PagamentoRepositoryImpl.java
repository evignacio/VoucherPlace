package org.techchallenge.checkout.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.checkout.application.VoucherDTO;
import org.techchallenge.checkout.domain.repository.PagamentoRepository;
import org.techchallenge.checkout.infrastructure.integration.http.GatewayPagamentoHttpClient;

import java.math.BigDecimal;

@Repository
@RequiredArgsConstructor
public class PagamentoRepositoryImpl implements PagamentoRepository {

    private final GatewayPagamentoHttpClient gatewayPagamentoHttpClient;

    @Override
    public String efetuarPagamento(VoucherDTO voucherDTO, BigDecimal valor) {
        return this.gatewayPagamentoHttpClient.criarTransacao(voucherDTO, valor);
    }
}
