package org.techchallenge.vendas.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Service;
import org.techchallenge.vendas.domain.entity.factory.ProdutoFactory;
import org.techchallenge.vendas.domain.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@JBossLog
public class CadastroProdutoService {
    private final ProdutoRepository produtoRepository;

    public void cadastrar(String nome, String sku, String fabricante, BigDecimal preco, List<String> categorias) {
        log.infof("INIT %s.cadastrar", this.getClass().getName());
        var produto = ProdutoFactory.criar(nome, sku, fabricante, preco, categorias);
        this.produtoRepository.salvar(produto);
    }
}
