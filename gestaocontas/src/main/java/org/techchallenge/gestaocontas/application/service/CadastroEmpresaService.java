package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.entity.factory.EmpresaFactory;
import org.techchallenge.gestaocontas.domain.repository.ConsultaDetalhadaEmpresaRepository;
import org.techchallenge.gestaocontas.domain.repository.EmpresaRepository;
import org.techchallenge.gestaocontas.domain.repository.NotificacaoRepository;
import org.techchallenge.gestaocontas.domain.service.GerarSenhaService;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;
import org.techchallenge.gestaocontas.domain.valueobject.Contato;
import org.techchallenge.gestaocontas.domain.valueobject.Email;

@Service
@RequiredArgsConstructor
public class CadastroEmpresaService {
    private final ConsultaDetalhadaEmpresaRepository consultaDetalhadaEmpresaRepository;
    private final EmpresaRepository empresaRepository;
    private final GerarSenhaService gerarSenhaService;
    private final NotificacaoRepository notificacaoRepository;

    public void cadastrar(Email emailAcesso, Cnpj cnpj, Contato contato) {
        var dadosComplementaresEmpresa = this.consultaDetalhadaEmpresaRepository.consultar(cnpj);
        var empresa = EmpresaFactory.criar(emailAcesso, cnpj, contato, dadosComplementaresEmpresa);
        var senha = this.gerarSenhaService.gerarSenha(cnpj.getCnpj());
        this.notificacaoRepository.notificarEmpresaCadastro(empresa, senha);
        empresa.setSenhaAcesso(this.gerarSenhaService.criptografarSenha(senha));
        this.empresaRepository.salvar(empresa);
    }
}
