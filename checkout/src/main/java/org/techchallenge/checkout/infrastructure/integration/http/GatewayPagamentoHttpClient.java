package org.techchallenge.checkout.infrastructure.integration.http;

import org.springframework.stereotype.Component;
import org.techchallenge.checkout.application.VoucherDTO;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class GatewayPagamentoHttpClient {

    public String criarTransacao(VoucherDTO voucherDTO, BigDecimal valor) {
        var idTransacao = UUID.randomUUID().toString();
        System.out.printf("""
                ##---------------------------------------------##
                Pagamento realizado com sucesso
                Cartao: ******%s
                Valor: R$ %.2f
                IdTransacao: %s
                ##---------------------------------------------##
                """, voucherDTO.numero().substring(0, 4), valor, idTransacao);
        return idTransacao;
    }
}
