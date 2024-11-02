package org.techchallenge.vendas.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Service;
import org.techchallenge.vendas.application.dto.EstoqueDTO;
import org.techchallenge.vendas.domain.repository.EstoqueRepository;

@Service
@RequiredArgsConstructor
@JBossLog
public class BuscarEstoquePorProdutoService {
    private final EstoqueRepository estoqueRepository;

    public EstoqueDTO buscar(String sku) {
        log.infof("INIT %s.buscar", this.getClass().getName());
        return EstoqueDTO.from(this.estoqueRepository.buscar(sku));
    }
}
