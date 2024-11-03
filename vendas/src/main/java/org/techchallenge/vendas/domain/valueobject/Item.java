package org.techchallenge.vendas.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
}
