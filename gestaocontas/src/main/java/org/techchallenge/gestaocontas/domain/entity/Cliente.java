package org.techchallenge.gestaocontas.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.gestaocontas.domain.valueobject.Cpf;
import org.techchallenge.gestaocontas.domain.valueobject.Email;
import org.techchallenge.gestaocontas.domain.valueobject.Telefone;
import org.techchallenge.gestaocontas.domain.valueobject.Usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Cliente extends Usuario implements Serializable {
    private static final long serialVersionUID = -8300876520181586593L;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;
    @Embedded
    private Cpf cpf;
    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;
    @Embedded
    private Telefone telefone;
    //private Set<Endereco> enderecos = new HashSet<>();


    public Cliente(Email emailAcesso, String senhaAcesso, String nome, String sobrenome, Cpf cpf, LocalDate dataNascimento, Telefone telefone) {
        this.setEmailAcesso(emailAcesso);
        this.setSenhaAcesso(senhaAcesso);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(super.getId(), cliente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.getId());
    }
}
