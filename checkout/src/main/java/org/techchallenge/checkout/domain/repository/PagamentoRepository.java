package org.techchallenge.checkout.domain.repository;

import org.techchallenge.checkout.application.VoucherDTO;

import java.math.BigDecimal;

public interface PagamentoRepository {
    String efetuarPagamento(VoucherDTO voucherDTO, BigDecimal valor);
}
