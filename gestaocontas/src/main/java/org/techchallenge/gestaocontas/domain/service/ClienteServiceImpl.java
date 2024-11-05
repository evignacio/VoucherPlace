package org.techchallenge.gestaocontas.domain.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.shared.dto.ClienteDTO;
import org.techchallenge.shared.dto.EnderecoDTO;
import org.techchallenge.shared.service.ClienteService;
import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.repository.ClienteRepository;
import org.techchallenge.shared.exception.ApplicationException;
import org.techchallenge.gestaocontas.domain.valueobject.Cpf;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteDTO consultar(long idCliente) {
        var cliente = this.clienteRepository.consultar(idCliente)
                .orElseThrow(() -> ApplicationException.buildBusinessException("Cliente nao encontrado"));

        return this.toClienteDTO(cliente);

    }

    private ClienteDTO toClienteDTO(Cliente cliente) {
        Set<EnderecoDTO> enderecos = cliente.getEnderecos().stream()
                .map(e -> new EnderecoDTO(
                        e.getLogradouro(),
                        e.getNumero(),
                        e.getComplemento(),
                        e.getBairro(),
                        e.getCidade(),
                        e.getEstado(),
                        e.getCep()
                )).collect(Collectors.toSet());

        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getSobrenome(),
                cliente.getCpf().getCpf(),
                cliente.getDataNascimento(),
                cliente.getTelefone().getDdd(),
                cliente.getTelefone().getNumero(),
                enderecos
        );
    }

    public Cliente consultarClienteDetalhado(long idCliente) {
        return this.clienteRepository.consultar(idCliente)
                .orElseThrow(() -> ApplicationException.buildBusinessException("Cliente nao encontrado"));
    }

    @Override
    public boolean exite(String cpf) {
        return this.clienteRepository.consultar(new Cpf(cpf))
                .isPresent();
    }

    @Override
    public boolean exite(long idCliente) {
        return this.clienteRepository.consultar(idCliente)
                .isPresent();
    }
}
