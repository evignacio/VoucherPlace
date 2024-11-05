package org.techchallenge.vendas.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Service;
import org.techchallenge.shared.dto.CarrinhoDTO;
import org.techchallenge.vendas.domain.entity.Carrinho;
import org.techchallenge.vendas.domain.entity.Estoque;
import org.techchallenge.vendas.domain.entity.factory.CarrinhoFactory;
import org.techchallenge.vendas.domain.repository.CarrinhoRepository;
import org.techchallenge.vendas.domain.repository.EstoqueRepository;
import org.techchallenge.vendas.domain.repository.ProdutoCarrinhoRepository;
import org.techchallenge.vendas.domain.repository.ProdutoRepository;

import static org.techchallenge.shared.exception.ApplicationException.buildBusinessException;

@Service
@RequiredArgsConstructor
@JBossLog
public class CadastroCarrinhoService {
    private final CarrinhoRepository carrinhoRepository;
    private final EstoqueRepository estoqueRepository;
    private final ProdutoRepository produtoRepository;
    private final ProdutoCarrinhoRepository produtoCarrinhoRepository;

    public CarrinhoDTO cadastrar(String sku, int quantidadeProduto) {

        log.infof("INIT %s.cadastrar", this.getClass().getName());
        var estoque = estoqueRepository.buscar(sku);

        if (!estoque.isAtivo() || estoque.getQuantidadeProduto() < quantidadeProduto)
            throw buildBusinessException("Produto sem estoque no momento");

        reservarEstoque(estoque, quantidadeProduto);

        var produto = produtoRepository.buscar(sku)
                .orElseThrow(() -> buildBusinessException("Produto sem estoque no momento"));

        var carrinho = CarrinhoFactory.criar(produto, quantidadeProduto);
        this.produtoCarrinhoRepository.salvar(carrinho.getProdutos().getFirst());
        this.carrinhoRepository.salvar(carrinho);

        return new CarrinhoDTO(carrinho.getId(), carrinho.getValorTotal());
    }

    protected void reservarEstoque(Estoque estoque, int quantidade) {
        estoque.setQuantidadeProduto(estoque.getQuantidadeProduto() - quantidade);
        estoqueRepository.salvar(estoque);
    }
}
