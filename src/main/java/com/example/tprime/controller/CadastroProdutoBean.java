package com.example.tprime.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.tprime.model.*;
import com.example.tprime.service.ProdutoService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class CadastroProdutoBean {
    @Getter@Setter
    private Produto produto = new Produto();
    @Autowired
    private ProdutoService produtoService;

    @PostConstruct
    public void init() {
        produto = new Produto();
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        produtoService.salvar(produto);
        //Prepara para cadastrar um novo lancamento
        produto = new Produto();

        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
                "Produto cadastrado com sucesso.");
        context.addMessage(null, mensagem);

    }

    public void prepararCadastro() {
        produto = produtoService.buscarPorId(produto.getId());
    }

}
