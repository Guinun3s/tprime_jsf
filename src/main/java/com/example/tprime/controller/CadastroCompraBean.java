package com.example.tprime.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.tprime.model.*;
import com.example.tprime.service.CompraService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class CadastroCompraBean {
    @Getter@Setter
    private Compra compra = new Compra();
    @Autowired
    private CompraService compraService;

    @PostConstruct
    public void init() {
        compra = new Compra();
    }

    /*public void consultar() {
        todosCompras = compraService.buscarTodos();
        //System.out.println("entrou no post cronstructor");
    }*/

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        compraService.salvar(compra);
        //Prepara para cadastrar um novo lancamento
        compra = new Compra();

        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
                "Compra cadastrado com sucesso.");
        context.addMessage(null, mensagem);

    }

    public void prepararCadastro() {
        compra = compraService.buscarPorId(compra.getId());
        
    }


}
