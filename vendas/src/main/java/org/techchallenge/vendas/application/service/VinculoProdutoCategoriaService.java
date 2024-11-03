package org.techchallenge.vendas.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Service;
import org.techchallenge.vendas.domain.repository.CategoriaRepository;
import org.techchallenge.vendas.domain.repository.ProdutoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@JBossLog
public class VinculoProdutoCategoriaService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public void vincular(List<String> skus, String categoria) {
        log.infof("INIT %s.vincular", this.getClass().getName());
        var cat = this.categoriaRepository.buscar(categoria);
        var produtos = this.produtoRepository.buscar(skus);
        cat.setProdutos(produtos);
        this.categoriaRepository.salvar(cat);
    }
}
