package com.example.tprime.model;

import java.util.List;

import javax.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "PRODUTO")
public class Produto extends AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private float valor;

    //Relacionamento
    @ManyToMany(mappedBy = "produtos")
    private List<Compra> compras;

    //toString para exibir as informações do produto
    @Override
    public String toString() {
        return "\nProduto id= " + id + "\nnome= " + nome + "\nvalor= " + valor + "\n";
    }
}
