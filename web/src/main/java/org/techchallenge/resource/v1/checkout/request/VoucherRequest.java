package org.techchallenge.resource.v1.checkout.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VoucherRequest(
        @NotNull @Size(min = 3, max = 36, message = "Deve ter entre 3 e 36 caracteres") String nomeTitular,
        @NotNull @Size(min = 13, max = 13, message = "Deve ter 13 caracteres") String numero,
        @NotNull @Size(min = 4, max = 4, message = "Deve ter 4 caracteres") String dataVencimento,
        @NotNull @Size(min = 3, max = 3, message = "Deve ter 3 caracteres") String cvv
) {
}
