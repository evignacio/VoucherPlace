package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.entity.factory.EmpresaFactory;
import org.techchallenge.gestaocontas.domain.repository.ConsultaDetalhadaEmpresaRepository;
import org.techchallenge.gestaocontas.domain.repository.EmpresaRepository;
import org.techchallenge.gestaocontas.domain.repository.NotificacaoRepository;
import org.techchallenge.gestaocontas.domain.service.EmpresaService;
import org.techchallenge.gestaocontas.domain.service.GestaoAcessosService;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;
import org.techchallenge.gestaocontas.domain.valueobject.Contato;
import org.techchallenge.gestaocontas.domain.valueobject.Email;
import org.techchallenge.common.exception.ApplicationException;

@Service
@RequiredArgsConstructor
public class CadastroEmpresaService {
    private final ConsultaDetalhadaEmpresaRepository consultaDetalhadaEmpresaRepository;
    private final EmpresaRepository empresaRepository;
    private final GestaoAcessosService gerarSenhaService;
    private final NotificacaoRepository notificacaoRepository;
    private final EmpresaService consultarEmpresaService;

    public long cadastrar(Cnpj cnpj, Email emailAcesso, Contato contato) {
        if (consultarEmpresaService.cadastroJaRealizado(cnpj))
            throw ApplicationException.buildBusinessException("Empresa ja cadastrada");

        var dadosComplementaresEmpresa = this.consultaDetalhadaEmpresaRepository.consultar(cnpj);
        var empresa = EmpresaFactory.criar(emailAcesso, cnpj, contato, dadosComplementaresEmpresa);
        var senha = this.gerarSenhaService.gerarSenha(cnpj.getCnpj());
        this.notificacaoRepository.notificarEmpresaCadastro(empresa, senha);
        empresa.setSenhaAcesso(this.gerarSenhaService.criptografarSenha(senha));
        this.empresaRepository.salvar(empresa);

        return empresa.getId();
    }
}
