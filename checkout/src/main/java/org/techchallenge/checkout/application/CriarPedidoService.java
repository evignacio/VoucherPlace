package org.techchallenge.checkout.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.checkout.domain.entity.ItemPedido;
import org.techchallenge.checkout.domain.entity.Pedido;
import org.techchallenge.checkout.domain.repository.PedidoRepository;
import org.techchallenge.checkout.domain.valueobject.Endereco;
import org.techchallenge.common.exception.ApplicationException;
import org.techchallenge.common.service.ClienteService;
import org.techchallenge.common.service.EmpresaService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CriarPedidoService {

    private final EmpresaService empresaService;
    private final ClienteService clienteService;
    private final PedidoRepository pedidoRepository;

    public long criar(long idEmpresa, long idCliente, Set<ItemPedido> itensPedido, Endereco endereco) {
        if (!empresaService.existe(idEmpresa))
            throw ApplicationException.buildBusinessException("Nao foi possivel criar pedido, identificacao empresa invalida");

        if (!clienteService.exite(idCliente))
            throw ApplicationException.buildBusinessException("Nao foi possivel criar pedido, identificacao cliente invalida");

        var pedido = this.pedidoRepository.salvar(new Pedido(idEmpresa, idCliente, itensPedido, endereco));

        return pedido.getId();
    }
}
