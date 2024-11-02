package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.repository.ClienteRepository;
import org.techchallenge.gestaocontas.domain.service.ConsultarClienteService;
import org.techchallenge.gestaocontas.domain.service.GerarSenhaService;
import org.techchallenge.common.exception.ApplicationException;

@Service
@RequiredArgsConstructor
public class CadastroClienteService {

    private final ClienteRepository clienteRepository;
    private final ConsultarClienteService consultarClienteService;
    private final GerarSenhaService gerarSenhaService;

    public void cadastrar(Cliente cliente) {
        if (this.consultarClienteService.cadastroJaRealizado(cliente.getCpf()))
            throw ApplicationException.buildBusinessException("Cliente ja cadastrado");

        cliente.setSenhaAcesso(this.gerarSenhaService.criptografarSenha(cliente.getSenhaAcesso()));
        this.clienteRepository.salvar(cliente);
    }
}
