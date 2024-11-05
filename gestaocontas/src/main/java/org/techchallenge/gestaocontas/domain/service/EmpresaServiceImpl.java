package org.techchallenge.gestaocontas.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.techchallenge.shared.dto.ContatoDTO;
import org.techchallenge.shared.dto.EmpresaDTO;
import org.techchallenge.shared.dto.EnderecoDTO;
import org.techchallenge.shared.exception.ApplicationException;
import org.techchallenge.shared.service.EmpresaService;
import org.techchallenge.gestaocontas.domain.repository.EmpresaRepository;
import org.techchallenge.gestaocontas.domain.valueobject.Cnpj;


@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaDTO consultar(long idEmpresa) {
        var empresa = this.empresaRepository.consultar(idEmpresa)
                .orElseThrow(() -> ApplicationException.buildBusinessException("Empresa nao encontrada"));

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

    @Override
    public boolean existe(String cnpj) {
        return this.empresaRepository.consultar(new Cnpj(cnpj))
                .isPresent();
    }

    @Override
    public boolean existe(long idEmpresa) {
        return this.empresaRepository.consultar(idEmpresa)
                .isPresent();
    }
}
