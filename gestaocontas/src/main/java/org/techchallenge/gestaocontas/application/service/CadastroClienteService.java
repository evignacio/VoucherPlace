package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.repository.ClienteRepository;
import org.techchallenge.gestaocontas.domain.service.GerarSenhaService;

@Service
@RequiredArgsConstructor
public class CadastroClienteService {

    private final ClienteRepository clienteRepository;
    private final GerarSenhaService gerarSenhaService;

    public void cadastrar(Cliente cliente) {
        cliente.setSenhaAcesso(this.gerarSenhaService.criptografarSenha(cliente.getSenhaAcesso()));
        this.clienteRepository.salvar(cliente);
    }
}
