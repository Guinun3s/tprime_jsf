package com.example.tprime.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.tprime.model.Cliente;
import com.example.tprime.model.Compra;
import com.example.tprime.service.ClienteService;
import com.example.tprime.service.CompraService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class ClientesDevendoBean {
    @Getter
    private List<Cliente> clientes;

    @Getter
    private List<Compra> todasCompras;

    @Getter @Setter
    private Cliente clienteSelecionado;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CompraService compraService;

    @PostConstruct
    public void init(){
        clientes = clienteService.buscarTodos();
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getDivida() == 0) {
                iterator.remove();
            }
        }
        todasCompras = compraService.buscarTodos();
    }
    
}
