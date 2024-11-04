package org.techchallenge.resource.v1.gestaocontas.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroClienteRequest(
        @NotNull @Size(min = 5, max = 36, message = "deve ter entre 5 e 36 caracteres") String emailAcesso,
        @NotNull @Size(min = 5, max = 36, message = "deve ter entre 5 e 36 caracteres") String senhaAcesso,
        @NotNull @Size(min = 5, max = 36, message = "deve ter entre 3 e 36 caracteres") String nome,
        @NotNull @Size(min = 5, max = 36, message = "deve ter entre 3 e 36 caracteres") String sobreNome,
        @NotNull @Size(min = 11, max = 11, message = "deve ter 11 caracteres") String cpf,
        @NotNull LocalDate dataNascimento,
        @NotNull TelefoneRequest telefone
) {
}
