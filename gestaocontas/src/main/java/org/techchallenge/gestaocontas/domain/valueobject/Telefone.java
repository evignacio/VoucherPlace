package org.techchallenge.gestaocontas.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.techchallenge.gestaocontas.domain.exception.ApplicationException;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Telefone {
    @Column(name = "telefone_ddd", nullable = false)
    private String ddd;
    @Column(name = "telefone_numero", nullable = false)
    private String numero;
    @Enumerated(EnumType.STRING)
    @Column(name = "telefone_tipo", nullable = false)
    private TipoTelefone tipo;

    public Telefone(String ddd, String numero) {
        this.setDdd(ddd);
        this.setNumero(numero);
        this.tipo = this.getTipo();
    }

    private void setDdd(@NotNull String ddd) {
        var exception = ApplicationException.buildValidationException("DDD invalido");

        if (ddd.isEmpty())
            throw exception;

        ddd = ddd.replace(" ", "");
        ddd = ddd.replaceAll("\\D", "");

        if (ddd.length() != 2)
            throw exception;

        this.ddd = ddd;
    }

    private void setNumero(@NotNull String numero) {
        var exception = ApplicationException.buildValidationException("Numero invalido");

        if (numero.isEmpty())
            throw exception;

        numero = numero.replace(" ", "");
        numero = numero.replaceAll("\\D", "");

        if (numero.length() < 8 || numero.length() > 9)
            throw exception;

        this.numero = numero;
    }

    public TipoTelefone getTipo() {
        if (this.numero.charAt(0) != '9')
            return TipoTelefone.FIXO;

        return TipoTelefone.MOVEL;
    }
}
