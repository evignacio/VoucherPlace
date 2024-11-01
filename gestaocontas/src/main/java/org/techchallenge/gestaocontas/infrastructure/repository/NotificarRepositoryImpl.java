package org.techchallenge.gestaocontas.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.gestaocontas.domain.entity.Empresa;
import org.techchallenge.gestaocontas.domain.repository.NotificacaoRepository;
import org.techchallenge.gestaocontas.infrastructure.integration.smtp.SmtpClient;

@Repository
@RequiredArgsConstructor
public class NotificarRepositoryImpl implements NotificacaoRepository {

    private final SmtpClient smtpClient;

    @Override
    public void notificarEmpresaCadastro(Empresa empresa, String senhaAcesso) {
        var emailAcesso = empresa.getEmailAcesso().getEmail();
        var mensagem = String.format("""
                        Bem vinda ao VoucherPlace %s, para acessar a plataforma
                        e gerenciar seus produtos utilize os dados a seguir:
                        Email: %s
                        Senha: %s
                        """,
                empresa.getNomeFantasia(), emailAcesso, senhaAcesso);
        this.smtpClient.enviarEmail(emailAcesso, mensagem);
    }
}
