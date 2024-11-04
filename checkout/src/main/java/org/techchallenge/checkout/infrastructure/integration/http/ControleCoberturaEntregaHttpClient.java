package org.techchallenge.checkout.infrastructure.integration.http;

import org.springframework.stereotype.Component;

@Component
public class ControleCoberturaEntregaHttpClient {
    public boolean temCobertura(long idEmpresa, String cep) {
        return !cep.equals("11025905");
    }
}
