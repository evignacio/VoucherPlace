package org.techchallenge.vendas.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Service;
import org.techchallenge.vendas.domain.entity.Produto;
import org.techchallenge.vendas.domain.repository.EstoqueRepository;
import org.techchallenge.vendas.domain.repository.ProdutoRepository;
import org.techchallenge.vendas.domain.service.ProdutoServiceImpl;

import static org.techchallenge.vendas.domain.entity.factory.EstoqueFactory.criar;

@Service
@RequiredArgsConstructor
@JBossLog
public class CadastroEstoqueProdutoService {
    private final EstoqueRepository estoqueRepository;
    private final ProdutoServiceImpl produtoService;

    public void cadastrar(String sku, int quantidade) {
        log.infof("INIT %s.cadastrar", this.getClass().getName());
        var produto = this.buscarProduto(sku);
        var estoque = criar(produto, quantidade, false);
        this.estoqueRepository.salvar(estoque);
    }

    protected Produto buscarProduto(String sku) {
        return this.produtoService.buscar(sku);
    }
}
