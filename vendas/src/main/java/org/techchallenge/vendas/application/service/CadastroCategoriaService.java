package org.techchallenge.vendas.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Service;
import org.techchallenge.vendas.domain.entity.factory.CategoriaFactory;
import org.techchallenge.vendas.domain.repository.CategoriaRepository;

@Service
@RequiredArgsConstructor
@JBossLog
public class CadastroCategoriaService {
    private final CategoriaRepository categoriaRepository;

    public void cadastrar(String titulo) {
        log.infof("INIT %s.cadastrar", this.getClass().getName());
        var categoria = CategoriaFactory.criar(titulo);
        this.categoriaRepository.salvar(categoria);
    }
}
