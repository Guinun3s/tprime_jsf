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
import com.example.tprime.service.CompraService;
import com.example.tprime.service.ProdutoService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class CadastroCompraBean {
    @Getter @Setter
    private Compra compra = new Compra();

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Getter @Setter
    private Long clienteId;

    @Getter
    private List<Cliente> clientes;

    @Getter
    private List<Produto> produtos;

    @PostConstruct
    public void init() {
        clientes = clienteService.buscarTodos();
        produtos = produtoService.buscarTodos();
    }

    public void salvar() {
        FacesContext context = FacesContext.getCurrentInstance();
        Cliente cliente = clienteService.buscarPorId(clienteId);
        compra.setCliente(cliente);
        compraService.salvar(compra);

        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
                "Compra cadastrada com sucesso.");
        context.addMessage(null, mensagem);
    }

    public void prepararCadastro() {
        if (compra == null) {
            compra = new Compra();
        } else if (compra.getId() != null) {
            compra = compraService.buscarPorId(compra.getId());
        }
        if (clienteId != null) {
            Cliente cliente = clienteService.buscarPorId(clienteId);
            compra.setCliente(cliente);
        }
    }
}

