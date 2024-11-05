package org.techchallenge.resource.v1.checkout.request;

import jakarta.validation.constraints.NotNull;
import org.techchallenge.checkout.domain.entity.MetodoPagamento;

public record EfetuarPagamentoRequest(
        @NotNull MetodoPagamento metodoPagamento,
        @NotNull int qtdParcelas,
        @NotNull VoucherRequest voucher) {
}
