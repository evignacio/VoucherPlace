package org.techchallenge.common.dto;


public record EmpresaDTO(
        long id,
        String nomeFantasia,
        String razaoSocial,
        String cnpj,
        EnderecoDTO endereco,
        ContatoDTO contato) {
}
