package com.example.tprime.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import com.example.tprime.model.Cliente;
import com.example.tprime.service.ClienteService;
import com.example.tprime.service.PagamentoService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class PagamentoDividaBean implements Serializable {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PagamentoService pagamentoService;

    @Getter @Setter
    private Cliente cliente;

    @Getter @Setter
    private Long clienteId;

    @Getter @Setter
    private Double valorTotalDivida;

    @Getter @Setter
    private Double valorPagamento;

    @PostConstruct
    public void init() {
        // Inicialização
    }

    public void prepararPagamento() {
        if (clienteId != null) {
            cliente = clienteService.buscarPorId(clienteId);
            calcularValorTotalDivida();
        }
    }

    private void calcularValorTotalDivida() {
        valorTotalDivida = cliente.getDivida();
    }

    public void pagar() {
        if (valorPagamento != null && valorPagamento > 0 && valorPagamento <= valorTotalDivida) {
            pagamentoService.pagarDivida(clienteId, valorPagamento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pagamento realizado com sucesso!"));
            prepararPagamento(); // Recalcular a dívida restante
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Valor de pagamento inválido"));
        }
    }
}