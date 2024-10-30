package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.entity.factory.EmpresaFactory;
import org.techchallenge.gestaocontas.domain.repository.ConsultaDetalhadaEmpresaRepository;
import org.techchallenge.gestaocontas.domain.repository.EmpresaRepository;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;
import org.techchallenge.gestaocontas.domain.valueobject.Contato;

@Service
@RequiredArgsConstructor
public class CadastroEmpresaService {
    private final ConsultaDetalhadaEmpresaRepository consultaDetalhadaEmpresaRepository;
    private final EmpresaRepository empresaRepository;

    public void cadastrar(Cnpj cnpj, Contato contato) {
        var dadosComplementaresEmpresa = this.consultaDetalhadaEmpresaRepository.consultar(cnpj);
        var empresa = EmpresaFactory.criar(cnpj, contato, dadosComplementaresEmpresa);
        this.empresaRepository.salvar(empresa);
    }
}
