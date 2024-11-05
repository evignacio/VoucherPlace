package org.techchallenge.checkout.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.shared.exception.ApplicationException;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Endereco {
    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "cep", nullable = false)
    private String cep;

    public Endereco(@NotNull String logradouro, @NotNull String numero, String complemento, @NotNull String bairro, @NotNull String cidade, @NotNull String estado, @NotNull String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.setCep(cep);
    }

    private void setCep(@NotNull String cep) {
        var exception = ApplicationException.buildValidationException("Cep invalido");

        if (cep.isEmpty())
            throw exception;

        cep = cep.replace(" ", "");
        cep = cep.replaceAll("\\D", "");

        if (cep.length() != 8)
            throw exception;

        this.cep = cep;
    }
}
