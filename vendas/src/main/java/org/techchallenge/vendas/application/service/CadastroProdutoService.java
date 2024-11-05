package org.techchallenge.vendas.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Service;
import org.techchallenge.shared.exception.ApplicationException;
import org.techchallenge.shared.service.ProdutoService;
import org.techchallenge.vendas.domain.entity.factory.ProdutoFactory;
import org.techchallenge.vendas.domain.repository.ProdutoRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@JBossLog
public class CadastroProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    public String cadastrar(String nome, String sku, Long idEmpresa, String fabricante, BigDecimal preco) {
        if (this.produtoService.existe(sku))
            throw ApplicationException.buildBusinessException("Produto ja cadastrado");

        log.infof("INIT %s.cadastrar", this.getClass().getName());
        var produto = ProdutoFactory.criar(nome, sku, idEmpresa, fabricante, preco);
        this.produtoRepository.salvar(produto);

        return produto.getSku();
    }
}
