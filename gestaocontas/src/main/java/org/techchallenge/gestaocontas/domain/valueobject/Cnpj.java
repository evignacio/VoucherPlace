package org.techchallenge.gestaocontas.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.common.exception.ApplicationException;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Cnpj {
    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    public Cnpj(String cnpj) {
        this.setCnpj(cnpj);
    }

    private void setCnpj(String cnpj) {
        var exception = ApplicationException.buildValidationException("CNPJ invalido");

        if (Objects.isNull(cnpj) || cnpj.isBlank())
            throw exception;

        cnpj = cnpj.replace(" ", "");
        cnpj = cnpj.replaceAll("\\D", "");

        if (cnpj.length() != 14)
            throw exception;

        this.cnpj = cnpj;
    }
}
