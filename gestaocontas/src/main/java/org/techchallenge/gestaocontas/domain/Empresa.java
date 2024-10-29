package org.techchallenge.gestaocontas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;
import org.techchallenge.gestaocontas.domain.valueobject.Contato;
import org.techchallenge.gestaocontas.domain.valueobject.Endereco;

import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Empresa implements Serializable {

    private static final long serialVersionUID = -6602733079927740217L;
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Column(name = "razaoSocial", nullable = false)
    private String razaoSocial;
    @Embedded
    private Cnpj cnpj;
    @Embedded
    private Endereco endereco;
    @Embedded
    private Contato contato;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
