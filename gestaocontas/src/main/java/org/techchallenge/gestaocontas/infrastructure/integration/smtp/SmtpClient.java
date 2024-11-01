package org.techchallenge.gestaocontas.infrastructure.integration.smtp;

import org.springframework.stereotype.Component;

@Component
public class SmtpClient {
    public void enviarEmail(String remetente, String mensagem) {
        System.out.printf("""
                Remetente: %s
                Mensagem: %s
                %n""", remetente, mensagem);
    }
}
