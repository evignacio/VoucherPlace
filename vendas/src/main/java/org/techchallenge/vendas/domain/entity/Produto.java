package org.techchallenge.vendas.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Produto implements Serializable {

    private static final long serialVersionUID = -6602733079927740217L;
    @Id
    @Column(name = "sku", nullable = false)
    private String sku;
    @Column(name = "idEmpresa", nullable = false)
    private Long idEmpresa;
    @Column(name = "nome")
    private String nome;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "preco")
    private BigDecimal preco;
    @OneToOne(mappedBy = "produto")
    private Estoque estoque;
    @ManyToMany(mappedBy = "produtos")
    List<Categoria> categorias;

    public Produto(String sku, Long idEmpresa, String nome, String fabricante, BigDecimal preco) {
        this.sku = sku;
        this.idEmpresa = idEmpresa;
        this.nome = nome;
        this.fabricante = fabricante;
        this.preco = preco;
    }
}
