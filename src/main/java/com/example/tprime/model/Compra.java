package com.example.tprime.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "COMPRA")
public class Compra extends AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private float valor;

    @Column(nullable = false)
    private LocalDate dataCompra;

    //Atributo para verificar se a compra foi paga ou não
    @Column(nullable = false)
    private boolean situacao;

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

    @OneToOne(mappedBy = "compra", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    //toString para exibir as informações da compra
    @Override
    public String toString() {
        return "\nCompra id= " + id + "\nvalor= " + valor + "\ndataCompra= " + dataCompra + "\nsituação= " + situacao + "\n";
    }

}
