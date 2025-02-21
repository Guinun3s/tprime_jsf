package com.example.tprime.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "COMPRA")
public class Compra extends AbstractEntity<Long> {
   
    
    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private LocalDateTime dataCompra;

    //Relacionamentos
    @ManyToOne
    @JoinColumn(name = "id_cliente_fk")
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "compra_produto",
        joinColumns = @JoinColumn(name = "compra_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos;

}
