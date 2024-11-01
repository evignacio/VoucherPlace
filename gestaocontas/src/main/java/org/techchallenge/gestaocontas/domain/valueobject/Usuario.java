package org.techchallenge.gestaocontas.domain.valueobject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Usuario {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @Embedded
    @AttributeOverride(name = "email", column = @Column(name = "emailAcesso"))
    private Email emailAcesso;
    @Column(name = "senhaAcesso", nullable = false)
    private String senhaAcesso;
}
