package org.techchallenge.gestaocontas.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.common.exception.ApplicationException;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Cpf {
    @Column(name = "cpf", nullable = false)
    private String cpf;

    public Cpf(String cpf) {
        this.setCpf(cpf);
    }

    public void setCpf(@NotNull String cpf) {
        var exception = ApplicationException.buildValidationException("CPF invalido");
        if (cpf.isBlank())
            throw exception;

        cpf = cpf.replace(" ", "");
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11)
            throw exception;

        this.cpf = cpf;
    }
}
