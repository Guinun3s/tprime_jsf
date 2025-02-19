package com.example.tprime.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.tprime.service.ClienteService;
import com.example.tprime.service.ProdutoService;

import lombok.Getter;

@Component
@Scope("view")
public class DashboardBean {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Getter
    private int totalClientes;

    @Getter
    private int totalProdutos;

    @Getter
    private int clientesComDivida;

    @PostConstruct
    public void init() {
        totalClientes = clienteService.buscarTodos().size();
        totalProdutos = produtoService.buscarTodos().size();
        clientesComDivida = clienteService.buscarClientesComDivida().size();
    }

}