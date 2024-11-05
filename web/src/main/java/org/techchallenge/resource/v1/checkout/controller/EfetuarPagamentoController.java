package org.techchallenge.resource.v1.checkout.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techchallenge.checkout.application.EfetuarPagamentoService;
import org.techchallenge.checkout.application.VoucherDTO;
import org.techchallenge.resource.v1.Resposta;
import org.techchallenge.resource.v1.checkout.request.EfetuarPagamentoRequest;
import org.techchallenge.resource.v1.checkout.response.EfeturarPagamentoResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("pedidos/{idPedido}/pagamento")
public class EfetuarPagamentoController {

    private final EfetuarPagamentoService efetuarPagamentoService;

    @PostMapping
    public ResponseEntity<Resposta<EfeturarPagamentoResponse>> efetuarPagamento(@PathVariable Long idPedido, @RequestBody EfetuarPagamentoRequest request) {
        var idTransacao = this.efetuarPagamentoService.efetuarPagamento(
                idPedido,
                request.metodoPagamento(),
                request.qtdParcelas(),
                this.toVoucherDTO(request)
        );

        return new ResponseEntity<>(Resposta.criar(new EfeturarPagamentoResponse(idTransacao)), HttpStatus.CREATED);
    }

    private VoucherDTO toVoucherDTO(EfetuarPagamentoRequest request) {
        var voucherRequest = request.voucher();
        return new VoucherDTO(
                voucherRequest.nomeTitular(),
                voucherRequest.numero(),
                voucherRequest.dataVencimento(),
                voucherRequest.cvv());
    }
}
