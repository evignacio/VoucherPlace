package org.techchallenge.gestaocontas.domain.repository;

import org.techchallenge.gestaocontas.application.dto.DadosComplementaresEmpresaDTO;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;

public interface ConsultaDetalhadaEmpresaRepository {
    DadosComplementaresEmpresaDTO consultar(Cnpj cnpj);
}
