package com.example.tprime.controller;

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
public class ConsultaClientesBean {
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
        todasCompras = compraService.buscarTodos();
    }

    public void excluir(){
        FacesContext context = FacesContext.getCurrentInstance();
        //remove a nd do banco de dados
        clienteService.excluir(clienteSelecionado.getId());
        context.addMessage(null, new FacesMessage("Exclusão", "Cliente excluído com sucesso."));
        //consultar();
        clientes = clienteService.buscarTodos();
    }
    
}
