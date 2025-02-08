package com.example.tprime.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.tprime.model.Cliente;
import com.example.tprime.service.ClienteService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class ConsultaClienteBean {
    @Getter
    private List<Cliente> clientes;

    @Getter @Setter
    private Cliente clienteSelecionado;

    @Autowired
    private ClienteService clienteService;

    @PostConstruct
    public void init(){
        clientes = clienteService.buscarTodos();
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
