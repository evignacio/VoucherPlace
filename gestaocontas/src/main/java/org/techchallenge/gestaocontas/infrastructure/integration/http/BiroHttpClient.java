package org.techchallenge.gestaocontas.infrastructure.integration.http;

import org.springframework.stereotype.Component;
import org.techchallenge.gestaocontas.application.dto.DadosComplementaresEmpresaDTO;
import org.techchallenge.gestaocontas.application.dto.EnderecoDTO;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;

@Component
public class BiroHttpClient {

    public DadosComplementaresEmpresaDTO consultar(Cnpj cnpj) {
        var endereco = new EnderecoDTO(
                "Rua Euclydes da Cunha",
                "223",
                "quadra 2",
                "Vila Mathias",
                "Santos",
                "SP",
                "11025-905"
        );

        if (cnpj.getCnpj().equals("05720367000101")) {
            return new DadosComplementaresEmpresaDTO(
                    "MacDonalds",
                    "MacDonalds LTA",
                    cnpj.getCnpj(),
                    "13997125044",
                    "mac@oficial.com",
                    endereco,
                    true
            );
        }

        return new DadosComplementaresEmpresaDTO(
                "Empresa feliz",
                "Empresa feliz sem restricao",
                cnpj.getCnpj(),
                "1399724595",
                "emrpesa@oficial.com",
                endereco,
                false
        );
    }
}
