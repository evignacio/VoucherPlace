package org.techchallenge.checkout.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.checkout.domain.repository.ValidaCoberturaEntregaRepository;
import org.techchallenge.checkout.infrastructure.integration.http.ControleCoberturaEntregaHttpClient;

@Repository
@RequiredArgsConstructor
public class ValidaCoberturaEntregaRepositoryImpl implements ValidaCoberturaEntregaRepository {

    private final ControleCoberturaEntregaHttpClient controleCoberturaEntregaHttpClient;

    @Override
    public boolean temCobertura(long idEmpresa, String cep) {
        return this.controleCoberturaEntregaHttpClient.temCobertura(idEmpresa, cep);
    }
}
