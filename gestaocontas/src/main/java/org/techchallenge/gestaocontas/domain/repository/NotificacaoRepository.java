package org.techchallenge.gestaocontas.domain.repository;

import org.techchallenge.gestaocontas.domain.entity.Empresa;

public interface NotificacaoRepository {
    void notificarEmpresaCadastro(Empresa empresa, String senhaAcesso);
}
