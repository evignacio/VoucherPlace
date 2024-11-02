package org.techchallenge.gestaocontas.domain.valueobject;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.common.exception.ApplicationException;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Email {
    private String email;

    public Email(String email) {
        this.setEmail(email);
    }

    private void setEmail(@NotNull String email) {
        var exception = ApplicationException.buildValidationException("Email invalido");

        if (email.isBlank() || email.length() < 5 || email.length() > 36)
            throw exception;

        email = email.toLowerCase();
        email = email.replaceAll(" ", "");

        if (!email.contains("@"))
            throw exception;

        this.email = email;
    }

}
