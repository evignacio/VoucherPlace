package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.application.dto.ClienteDTO;
import org.techchallenge.gestaocontas.application.dto.EnderecoDTO;
import org.techchallenge.gestaocontas.domain.entity.Cliente;
import org.techchallenge.gestaocontas.domain.service.ClienteService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsultarClienteService {

    private final ClienteService clienteService;

    public ClienteDTO consultar(long idCliente) {
        var cliente = this.clienteService.consultar(idCliente);
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
}
