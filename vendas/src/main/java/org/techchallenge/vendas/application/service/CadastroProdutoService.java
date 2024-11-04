package org.techchallenge.vendas.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Service;
import org.techchallenge.vendas.domain.entity.factory.ProdutoFactory;
import org.techchallenge.vendas.domain.repository.ProdutoRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@JBossLog
public class CadastroProdutoService {
    private final ProdutoRepository produtoRepository;

    public void cadastrar(String nome, String sku, Long idEmpresa, String fabricante, BigDecimal preco) {
        log.infof("INIT %s.cadastrar", this.getClass().getName());
        var produto = ProdutoFactory.criar(nome, sku, idEmpresa, fabricante, preco);
        this.produtoRepository.salvar(produto);
    }
}
