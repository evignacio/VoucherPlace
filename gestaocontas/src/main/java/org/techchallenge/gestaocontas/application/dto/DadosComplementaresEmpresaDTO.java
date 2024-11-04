package org.techchallenge.gestaocontas.application.dto;

import org.techchallenge.common.dto.EnderecoDTO;

public record DadosComplementaresEmpresaDTO(
        String nomeFantasia,
        String razaoSocial,
        String cnpj,
        String telefone,
        String email,
        EnderecoDTO endereco,
        boolean comRestricao
) {}