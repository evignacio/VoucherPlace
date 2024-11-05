package org.techchallenge.checkout.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.checkout.domain.entity.ItemPedido;
import org.techchallenge.checkout.domain.entity.Pedido;
import org.techchallenge.checkout.domain.repository.PedidoRepository;
import org.techchallenge.checkout.domain.repository.ValidaCoberturaEntregaRepository;
import org.techchallenge.checkout.domain.valueobject.Endereco;
import org.techchallenge.shared.exception.ApplicationException;
import org.techchallenge.shared.service.ClienteService;
import org.techchallenge.shared.service.EmpresaService;
import org.techchallenge.shared.service.ProdutoService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CriarPedidoService {

    private final EmpresaService empresaService;
    private final ClienteService clienteService;
    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;
    private final ValidaCoberturaEntregaRepository validaCoberturaEntregaRepository;

    public long criar(long idEmpresa, long idCliente, Set<ItemPedido> itensPedido, Endereco endereco) {
        if (!empresaService.existe(idEmpresa))
            throw ApplicationException.buildBusinessException("Nao foi possivel criar pedido, identificacao empresa invalida");

        if (!clienteService.exite(idCliente))
            throw ApplicationException.buildBusinessException("Nao foi possivel criar pedido, identificacao cliente invalida");

        if(!this.validaCoberturaEntregaRepository.temCobertura(idEmpresa, endereco.getCep()))
            throw ApplicationException.buildBusinessException("Nao foi possivel criar pedido, regiao de entrega informada nao atendida pela empresa");

        boolean produtosExistentes = itensPedido.stream().allMatch(i -> this.produtoService.existe(i.getSku()));

        if(!produtosExistentes)
            throw ApplicationException.buildBusinessException("Nao foi possivel criar pedido, ha produtos invalidos");

        var pedido = this.pedidoRepository.salvar(new Pedido(idEmpresa, idCliente, itensPedido, endereco));

        return pedido.getId();
    }
}
