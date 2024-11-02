package org.techchallenge.web.v1.request;

import jakarta.validation.constraints.Size;

public record Telefone(
        @Size(min = 2, max = 2, message = "deve ter 2 caracteres") String ddd,
        @Size(min = 8, max = 9, message = "deve ter entre 8 e 9 caracteres") String numero) {
}
