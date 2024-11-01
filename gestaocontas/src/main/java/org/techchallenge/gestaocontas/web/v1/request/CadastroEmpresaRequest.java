package org.techchallenge.gestaocontas.web.v1.request;

public record CadastroEmpresaRequest(String cnpj, String emailAcesso, String telefone, String emailContato) {
}
