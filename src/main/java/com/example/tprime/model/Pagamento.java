package com.example.tprime.model;

import java.util.Date;

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
    
    //toString para exibir as informações do pagamento
    @Override
    public String toString() {
        return "\nPagamento id= " + id + "\ndataPagamento= " + dataPagamento + "\nformaPagamento= " + formaPagamento + "\nvalor= " + valor + "\n";
    }
}
