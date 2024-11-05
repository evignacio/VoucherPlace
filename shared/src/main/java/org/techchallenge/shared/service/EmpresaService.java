package org.techchallenge.shared.service;


import org.techchallenge.shared.dto.EmpresaDTO;

public interface EmpresaService {

    EmpresaDTO consultar(long idEmpresa);

    boolean existe(String cnpj);

    boolean existe(long idEmpresa);
}
