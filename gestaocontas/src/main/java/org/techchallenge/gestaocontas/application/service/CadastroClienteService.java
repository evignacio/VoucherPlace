package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.repository.ClienteRepository;
import org.techchallenge.gestaocontas.domain.service.ClienteServiceImpl;
import org.techchallenge.gestaocontas.domain.service.GestaoAcessosService;
import org.techchallenge.common.exception.ApplicationException;

@Service
@RequiredArgsConstructor
public class CadastroClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteServiceImpl consultarClienteService;
    private final GestaoAcessosService gerarSenhaService;

    public long cadastrar(Cliente cliente) {
        if (this.consultarClienteService.exite(cliente.getCpf().getCpf()))
            throw ApplicationException.buildBusinessException("Cliente ja cadastrado");

        cliente.setSenhaAcesso(this.gerarSenhaService.criptografarSenha(cliente.getSenhaAcesso()));
        this.clienteRepository.salvar(cliente);

        return cliente.getId();
    }
}
