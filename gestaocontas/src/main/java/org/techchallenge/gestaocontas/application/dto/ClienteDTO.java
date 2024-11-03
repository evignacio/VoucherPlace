package org.techchallenge.gestaocontas.application.dto;

import java.time.LocalDate;
import java.util.Set;

public record ClienteDTO(
        long id,
        String nome,
        String sobrenome,
        String cpf,
        LocalDate dataNascimento,
        String ddd,
        String telefone,
        Set<EnderecoDTO> enderecos
) {
}
