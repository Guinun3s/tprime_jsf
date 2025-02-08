package com.example.tprime.model;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "PAGAMENTO")
public class Pagamento extends AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataPagamento;
    
    @Column(nullable = false)
    private String formaPagamento;

    @Column(nullable = false)
    private float valor;

    //Relacionamento
    @OneToOne
    @JoinColumn(name = "id_pagamento_fk")
    private Compra compra;
    
    //toString para exibir as informações do pagamento
    @Override
    public String toString() {
        return "\nPagamento id= " + id + "\ndataPagamento= " + dataPagamento + "\nformaPagamento= " + formaPagamento + "\nvalor= " + valor + "\n";
    }
}
