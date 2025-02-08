package com.example.tprime.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.tprime.model.*;
import com.example.tprime.service.ClienteService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class CadastroClienteBean {
    @Getter@Setter
    private Cliente cliente = new Cliente();
    @Autowired
    private ClienteService clienteService;

    @PostConstruct
    public void init() {
        cliente = new Cliente();
    }

    /*public void consultar() {
        todosClientes = clienteService.buscarTodos();
        //System.out.println("entrou no post cronstructor");
    }*/

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        clienteService.salvar(cliente);
        //Prepara para cadastrar um novo lancamento
        cliente = new Cliente();

        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
                "Cliente cadastrado com sucesso.");
        context.addMessage(null, mensagem);

    }

    public void prepararCadastro() {
        cliente = clienteService.buscarPorId(cliente.getId());
        
    }


}
