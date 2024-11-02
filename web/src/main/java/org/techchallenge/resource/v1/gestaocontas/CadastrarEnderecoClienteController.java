package org.techchallenge.resource.v1.gestaocontas;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techchallenge.gestaocontas.application.service.CadastrarEnderecoClienteServico;
import org.techchallenge.gestaocontas.domain.valueobject.Endereco;
import org.techchallenge.resource.v1.Resposta;
import org.techchallenge.resource.v1.gestaocontas.request.CadastrarEnderecoClienteRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes/{idCliente}")
public class CadastrarEnderecoClienteController {

    private final CadastrarEnderecoClienteServico cadastrarEnderecoClienteServico;

    @PostMapping("/enderecos")
    public ResponseEntity<Resposta> cadastrar(@PathVariable long idCliente, @Valid @RequestBody CadastrarEnderecoClienteRequest request) {
        this.cadastrarEnderecoClienteServico.cadastrar(idCliente, this.toEndereco(request));
        return new ResponseEntity<>(Resposta.criar(), HttpStatus.CREATED);
    }

    private Endereco toEndereco(CadastrarEnderecoClienteRequest request) {
        return new Endereco(
                request.logradouro(),
                request.numero(),
                request.complemento(),
                request.bairro(),
                request.cidade(),
                request.estado(),
                request.cep()
        );
    }
}
