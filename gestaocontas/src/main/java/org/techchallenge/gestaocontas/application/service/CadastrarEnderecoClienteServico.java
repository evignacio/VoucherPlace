package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.repository.ClienteRepository;
import org.techchallenge.gestaocontas.domain.service.ClienteServiceImpl;
import org.techchallenge.gestaocontas.domain.valueobject.Endereco;

@Service
@RequiredArgsConstructor
public class CadastrarEnderecoClienteServico {

    private final ClienteRepository clienteRepository;
    private final ClienteServiceImpl consultarClienteService;

    public void cadastrar(long idCliente, Endereco endereco) {
        var cliente = this.consultarClienteService.consultarClienteDetalhado(idCliente);
        cliente.adicionarEndereco(endereco);
        this.clienteRepository.salvar(cliente);
    }
}
