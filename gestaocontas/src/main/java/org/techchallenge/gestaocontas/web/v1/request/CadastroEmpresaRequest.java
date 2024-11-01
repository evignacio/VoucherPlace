package org.techchallenge.gestaocontas.web.v1.request;

import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;
import org.techchallenge.gestaocontas.domain.valueobject.Contato;
import org.techchallenge.gestaocontas.domain.valueobject.Email;

public record CadastroEmpresaRequest(Email emailAcesso, Cnpj cnpj, Contato contato) {
}
