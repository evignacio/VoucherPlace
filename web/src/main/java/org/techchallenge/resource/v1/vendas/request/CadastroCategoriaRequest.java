package org.techchallenge.resource.v1.vendas.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroCategoriaRequest(
        @NotBlank
        @Size(min = 4, max = 10, message = "deve ter no 14 caracteres")
        String titulo) {
}
