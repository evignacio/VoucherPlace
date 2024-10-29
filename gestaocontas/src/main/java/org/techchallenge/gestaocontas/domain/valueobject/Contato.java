package org.techchallenge.gestaocontas.domain.valueobject;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Contato {
    @Embedded
    private Telefone telefone;
    @Embedded
    private Email email;
}
