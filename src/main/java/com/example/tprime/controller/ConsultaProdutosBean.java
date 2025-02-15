package com.example.tprime.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.tprime.model.Produto;
import com.example.tprime.model.Compra;
import com.example.tprime.service.ProdutoService;
import com.example.tprime.service.CompraService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class ConsultaProdutosBean {
    @Getter
    private List<Produto> produtos;

    @Getter
    private List<Compra> todasCompras;

    @Getter @Setter
    private Produto produtoSelecionado;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CompraService compraService;

    @PostConstruct
    public void init(){
        produtos = produtoService.buscarTodos();
        todasCompras = compraService.buscarTodos();
    }

    public void excluir(){
        FacesContext context = FacesContext.getCurrentInstance();
        //remove a nd do banco de dados
        produtoService.excluir(produtoSelecionado.getId());
        context.addMessage(null, new FacesMessage("Exclusão", "Produto excluído com sucesso."));
        //consultar();
        produtos = produtoService.buscarTodos();
    }
    
}
