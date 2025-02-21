package com.example.tprime.model;

import java.util.List;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "PRODUTO")
public class Produto extends AbstractEntity<Long> {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private float valor;

    //Relacionamento
    @ManyToMany(mappedBy = "produtos")
    private List<Compra> compras;

}
