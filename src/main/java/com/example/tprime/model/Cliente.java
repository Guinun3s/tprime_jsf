package com.example.tprime.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "CLIENTE")
public class Cliente extends AbstractEntity<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private float divida;

    //Relacionamento
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Compra> compras = new ArrayList<>();

    //toString para exibir as informações do cliente
    @Override
    public String toString() {
        return "\nCliente id= " + id + "\nnome= " + nome + "\ncpf= " + cpf + "\ndataNas= " + dataNascimento + "\nemail= " + email
                + "\ntelefone= " + telefone + "\nendereco= " + endereco + "\ndivida= " + divida + "\n";
    }
    
}

