package org.techchallenge.vendas.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Service;
import org.techchallenge.vendas.application.dto.EstoqueDTO;
import org.techchallenge.vendas.domain.repository.EstoqueRepository;

@Service
@RequiredArgsConstructor
@JBossLog
public class AtivarEstoqueService {
    private final EstoqueRepository estoqueRepository;

    public EstoqueDTO ativar(String sku) {
        log.infof("INIT %s.buscar", this.getClass().getName());
        var estoque = this.estoqueRepository.buscar(sku);
        estoque.setAtivo(true);
        this.estoqueRepository.salvar(estoque);
        return EstoqueDTO.from(estoque);
    }
}
