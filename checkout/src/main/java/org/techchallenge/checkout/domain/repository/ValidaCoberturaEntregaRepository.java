package org.techchallenge.checkout.domain.repository;

public interface ValidaCoberturaEntregaRepository {

    boolean temCobertura(long idEmpresa, String cep);
}
