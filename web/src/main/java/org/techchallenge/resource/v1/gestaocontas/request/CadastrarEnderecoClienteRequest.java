package org.techchallenge.resource.v1.gestaocontas.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastrarEnderecoClienteRequest(
        @NotNull @Size(min = 3, max = 36, message = "deve ter entre 3 e 36 carecteres") String logradouro,
        @NotNull @Size(min = 1, max = 12, message = "deve ter entre 1 e 12 caracteres") String numero,
        @Size(min = 3, max = 36, message = "deve ter entre 3 e 36 carecteres") String complemento,
        @NotNull @Size(min = 3, max = 24, message = "deve ter entre 3 e 24 carecteres") String bairro,
        @NotNull @Size(min = 3, max = 24, message = "deve ter entre 3 e 24 carecteres") String cidade,
        @NotNull @Size(min = 2, max = 2, message = "deve ter 2 carecteres") String estado,
        @NotNull @Size(min = 8, max = 8, message = "deve ter 8 carecteres") String cep
) {
}
