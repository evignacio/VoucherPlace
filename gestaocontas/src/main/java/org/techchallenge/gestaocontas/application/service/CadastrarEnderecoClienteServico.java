package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.domain.repository.ClienteRepository;
import org.techchallenge.gestaocontas.domain.service.ConsultarClienteService;
import org.techchallenge.gestaocontas.domain.valueobject.Endereco;

@Service
@RequiredArgsConstructor
public class CadastrarEnderecoClienteServico {

    private final ClienteRepository clienteRepository;
    private final ConsultarClienteService consultarClienteService;

    public void cadastrar(long idCliente, Endereco endereco) {
        var cliente = this.consultarClienteService.consultar(idCliente);
        cliente.adicionarEndereco(endereco);
        this.clienteRepository.salvar(cliente);
    }
}
