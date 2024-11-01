package org.techchallenge.gestaocontas.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.gestaocontas.application.dto.DadosComplementaresEmpresaDTO;
import org.techchallenge.gestaocontas.domain.repository.ConsultaDetalhadaEmpresaRepository;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;
import org.techchallenge.gestaocontas.infrastructure.integration.http.BiroHttpClient;

@Repository
@RequiredArgsConstructor
public class ConsultaDetalhadaEmpresaRepositoryImpl implements ConsultaDetalhadaEmpresaRepository {

    private final BiroHttpClient biroHttpClient;

    @Override
    public DadosComplementaresEmpresaDTO consultar(Cnpj cnpj) {
        return this.biroHttpClient.consultar(cnpj);
    }
}
