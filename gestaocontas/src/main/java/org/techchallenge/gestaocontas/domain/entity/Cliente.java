package org.techchallenge.gestaocontas.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.gestaocontas.domain.valueobject.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    @ElementCollection
    @CollectionTable(name = "cliente_endereco", joinColumns = @JoinColumn(name = "cliente_id"))
    private Set<Endereco> enderecos = new HashSet<>();


    public Cliente(@NotNull Email emailAcesso, @NotNull String senhaAcesso, @NotNull String nome,
                   @NotNull String sobrenome, @NotNull Cpf cpf, @NotNull LocalDate dataNascimento,
                   @NotNull Telefone telefone) {
        this.setEmailAcesso(emailAcesso);
        this.setSenhaAcesso(senhaAcesso);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public void adicionarEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
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
