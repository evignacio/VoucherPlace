package org.techchallenge.gestaocontas.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.gestaocontas.application.dto.ContatoDTO;
import org.techchallenge.gestaocontas.application.dto.EmpresaDTO;
import org.techchallenge.gestaocontas.application.dto.EnderecoDTO;
import org.techchallenge.gestaocontas.domain.entity.Empresa;
import org.techchallenge.gestaocontas.domain.service.EmpresaService;

@Service
@RequiredArgsConstructor
public class ConsultarEmpresaService {

    private final EmpresaService empresaService;

    public EmpresaDTO consultar(long idEmpresa) {
        var empresa = this.empresaService.consultar(idEmpresa);
        return this.toEmpresaDTO(empresa);
    }

    private EmpresaDTO toEmpresaDTO(Empresa empresa) {
        var endereco = empresa.getEndereco();
        var enderecoDTO = new EnderecoDTO(
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep()
        );
        var contato = empresa.getContato();
        var contatoDTO = new ContatoDTO(
                contato.getEmail().getEmail(),
                contato.getTelefone().getDdd(),
                contato.getTelefone().getNumero()
        );
        return new EmpresaDTO(
                empresa.getId(),
                empresa.getNomeFantasia(),
                empresa.getRazaoSocial(),
                empresa.getCnpj().getCnpj(),
                enderecoDTO,
                contatoDTO
        );
    }
}
