package com.example.tprime.model;

import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "PAGAMENTO")
public class Pagamento extends AbstractEntity<Long> {
 

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPagamento;
    
    @Column(nullable = false)
    private String formaPagamento;

    @Column(nullable = false)
    private Double valor;

    //Relacionamento
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;
    
   
}
