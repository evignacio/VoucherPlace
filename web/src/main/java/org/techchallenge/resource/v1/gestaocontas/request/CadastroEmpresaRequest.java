package org.techchallenge.resource.v1.gestaocontas.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroEmpresaRequest(
        @NotNull @Size(min = 14, max = 14, message = "deve ter 14 caracteres") String cnpj,
        @NotNull @Size(min = 5, max = 36, message = "deve ter entre 5 e 36 caracteres") String emailAcesso,
        @Valid @NotNull TelefoneRequest telefone,
        @NotNull @Size(min = 5, max = 36, message = "deve ter entre 5 e 36 caracteres") String emailContato) {
}
