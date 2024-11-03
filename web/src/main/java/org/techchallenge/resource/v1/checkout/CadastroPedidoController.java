package org.techchallenge.resource.v1.checkout;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techchallenge.checkout.application.CriarPedidoService;
import org.techchallenge.checkout.domain.entity.ItemPedido;
import org.techchallenge.checkout.domain.valueobject.Endereco;
import org.techchallenge.resource.v1.Resposta;
import org.techchallenge.resource.v1.checkout.request.CriarPedidoRequest;
import org.techchallenge.resource.v1.checkout.request.ItemPedidoRequest;
import org.techchallenge.resource.v1.checkout.response.CriarPedidoResponse;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("pedidos")
public class CadastroPedidoController {

    private final CriarPedidoService criarPedidoService;

    @PostMapping
    public ResponseEntity<Resposta<Long>> criar(@RequestBody CriarPedidoRequest request) {
        var idPedido = this.criarPedidoService.criar(request.idEmpresa(), request.idCliente(), this.toItensPedido(request.itensPedido()), this.toEndereco(request));
        return new ResponseEntity<>(Resposta.criar(new CriarPedidoResponse(idPedido)), HttpStatus.CREATED);
    }

    private Set<ItemPedido> toItensPedido(Set<ItemPedidoRequest> requests) {
        return requests.stream().map(i -> new ItemPedido(
                i.sku(),
                i.quantidade(),
                i.valor()
        )).collect(Collectors.toSet());
    }

    private Endereco toEndereco(CriarPedidoRequest request) {
        return new Endereco(
                request.endereco().logradouro(),
                request.endereco().numero(),
                request.endereco().complemento(),
                request.endereco().bairro(),
                request.endereco().cidade(),
                request.endereco().estado(),
                request.endereco().cep()
        );
    }
}
