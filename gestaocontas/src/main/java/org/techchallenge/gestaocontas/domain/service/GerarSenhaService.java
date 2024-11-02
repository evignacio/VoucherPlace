package org.techchallenge.gestaocontas.domain.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.techchallenge.common.exception.ApplicationException;

@Service
public class GerarSenhaService {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String gerarSenha(String identificador) {
        identificador = identificador.replace(" ", "");

        if (identificador.length() < 4)
            throw ApplicationException.buildBusinessException("O identificador para geracao de senha deve ter no minimo 4 caracteres");

        return identificador.substring(0, 4) + "@" + String.valueOf(Math.random()).substring(0, 4);
    }

    public String criptografarSenha(String senha) {
        return passwordEncoder.encode(senha);
    }
}
