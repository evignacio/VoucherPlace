package org.techchallenge.gestaocontas.domain.entity.factory;

import org.techchallenge.gestaocontas.application.dto.DadosComplementaresEmpresaDTO;
import org.techchallenge.gestaocontas.domain.entity.Empresa;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;
import org.techchallenge.gestaocontas.domain.valueobject.Contato;
import org.techchallenge.gestaocontas.domain.valueobject.Endereco;

public abstract class EmpresaFactory {

    private EmpresaFactory() {

    }

    public static Empresa criar(Cnpj cnpj, Contato contato, DadosComplementaresEmpresaDTO dadosComplementareEmpresa) {
        if (dadosComplementareEmpresa.comRestricao())
            throw new RuntimeException("Nao foi possivel seguir com o cadastro da empresa, empresa com restricao na receita");

        var endereco = new Endereco(
                dadosComplementareEmpresa.endereco().logradouro(),
                dadosComplementareEmpresa.endereco().numero(),
                dadosComplementareEmpresa.endereco().complemento(),
                dadosComplementareEmpresa.endereco().bairro(),
                dadosComplementareEmpresa.endereco().cidade(),
                dadosComplementareEmpresa.endereco().estado(),
                dadosComplementareEmpresa.endereco().cep()
        );

        return new Empresa(
                dadosComplementareEmpresa.nomeFantasia(),
                dadosComplementareEmpresa.razaoSocial(),
                cnpj,
                endereco,
                contato
        );
    }
}
