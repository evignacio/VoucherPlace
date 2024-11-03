package org.techchallenge.gestaocontas.application.dto;

import org.techchallenge.gestaocontas.domain.valueobject.Contato;

public record EmpresaDTO(
        long id,
        String nomeFantasia,
        String razaoSocial,
        String cnpj,
        EnderecoDTO endereco,
        ContatoDTO contato) {
}
