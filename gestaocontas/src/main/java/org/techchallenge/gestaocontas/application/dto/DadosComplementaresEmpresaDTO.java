package org.techchallenge.gestaocontas.application.dto;

public record DadosComplementaresEmpresaDTO(
        String nomeFantasia,
        String razaoSocial,
        String cnpj,
        String telefone,
        String email,
        EnderecoDTO endereco,
        boolean comRestricao
) {}