package org.techchallenge.vendas.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.jbosslog.JBossLog;
import org.springframework.stereotype.Service;
import org.techchallenge.vendas.application.dto.CategoriaDTO;
import org.techchallenge.vendas.domain.repository.CategoriaRepository;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@JBossLog
public class BuscaCategoriasService {
    private final CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> buscar(String titulo, String sku) {
        log.infof("INIT %s.cadastrar", this.getClass().getName());
        if (Objects.nonNull(titulo))
            return this.buscarCategoriasPorTitulo(titulo);
        if (Objects.nonNull(sku))
            return this.buscarCategoriasPorSku(sku);
        return categoriaRepository.listar().stream().map(CategoriaDTO::from).toList();
    }

    protected List<CategoriaDTO> buscarCategoriasPorTitulo(String titulo) {
        var categoria = categoriaRepository.buscar(titulo);
        if(Objects.isNull(categoria))
            return Collections.emptyList();
        return Arrays.asList(CategoriaDTO.from(categoria));
    }

    protected List<CategoriaDTO> buscarCategoriasPorSku(String sku) {
        var categorias = categoriaRepository.buscarPorSku(sku);
        return categorias.stream().map(CategoriaDTO::from).toList();
    }
}
