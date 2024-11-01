package org.techchallenge.gestaocontas.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.gestaocontas.domain.valueobject.*;

import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends Usuario implements Serializable {

    private static final long serialVersionUID = -6602733079927740217L;
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

    public Empresa(Email emailAcesso, String nomeFantasia, String razaoSocial, Cnpj cnpj, Endereco endereco, Contato contato) {
        this.setEmailAcesso(emailAcesso);
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(super.getId(), empresa.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.getId());
    }
}
