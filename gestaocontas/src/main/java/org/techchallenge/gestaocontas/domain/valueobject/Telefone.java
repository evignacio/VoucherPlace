package org.techchallenge.gestaocontas.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Telefone {
    @Column(name = "telefone_numero", nullable = false)
    private String numero;
    @Enumerated(EnumType.STRING)
    @Column(name = "telefone_tipo", nullable = false)
    private TipoTelefone tipo;
}
