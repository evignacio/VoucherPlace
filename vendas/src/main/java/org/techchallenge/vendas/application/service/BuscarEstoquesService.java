package org.techchallenge.vendas.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Service;
import org.techchallenge.vendas.application.dto.EstoqueDTO;
import org.techchallenge.vendas.domain.repository.EstoqueRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@JBossLog
public class BuscarEstoquesService {
    private final EstoqueRepository estoqueRepository;

    public List<EstoqueDTO> buscar() {
        log.infof("INIT %s.buscar", this.getClass().getName());
        var estoques = this.estoqueRepository.listar();
        return estoques.stream().map(EstoqueDTO::from).toList();
    }
}
