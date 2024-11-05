package org.techchallenge.vendas.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.techchallenge.vendas.domain.entity.Carrinho;
import org.techchallenge.vendas.domain.repository.CarrinhoRepository;
import org.techchallenge.vendas.infrastructure.persistence.CarrinhoJPARepository;


@Repository
@RequiredArgsConstructor
public class CarrinhoRepositoryImpl implements CarrinhoRepository {
    private final CarrinhoJPARepository carrinhoJPARepository;

    @Override
    public Carrinho salvar(Carrinho carrinho) {
        return this.carrinhoJPARepository.save(carrinho);
    }

}
