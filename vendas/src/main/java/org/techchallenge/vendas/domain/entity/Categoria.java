package org.techchallenge.vendas.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table( name = "categoria", uniqueConstraints = @UniqueConstraint(columnNames = {"titulo"}) )
public class Categoria implements Serializable {

    private static final long serialVersionUID = -6602733079927740217L;
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @ManyToMany
    @JoinTable(name = "categoria_produto", joinColumns = @JoinColumn(name = "categoria_id"), inverseJoinColumns = @JoinColumn(name = "produto_sku"))
    private List<Produto> produtos;
    @Column(name = "titulo", nullable = false)
    private String titulo;

    public Categoria(String titulo) {
        this.titulo = titulo;
    }
}
