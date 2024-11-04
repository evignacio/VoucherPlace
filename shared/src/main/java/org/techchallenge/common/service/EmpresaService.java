package org.techchallenge.common.service;


import org.techchallenge.common.dto.EmpresaDTO;

public interface EmpresaService {

    EmpresaDTO consultar(long idEmpresa);

    boolean existe(String cnpj);

    boolean existe(long idEmpresa);
}
