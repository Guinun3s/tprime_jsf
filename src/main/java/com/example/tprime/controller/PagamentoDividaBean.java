package com.example.tprime.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import com.example.tprime.model.Cliente;
import com.example.tprime.model.Compra;
import com.example.tprime.model.Pagamento;
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
    private Long compraId;

    @Getter @Setter
    private Double valorTotalDivida;

    @Getter @Setter
    private Pagamento pagamento;

    @PostConstruct
    public void init() {
        pagamento = new Pagamento();
    }

    public void prepararPagamento() {
        if (clienteId != null) {
            cliente = clienteService.buscarPorId(clienteId);
            calcularValorTotalDivida();
            pagamento.setCliente(cliente);
            pagamento.setCompra(new Compra());
            pagamento.getCompra().setId(compraId);
        }
    }

    private void calcularValorTotalDivida() {
        valorTotalDivida = cliente.getDivida();
    }

    public void pagar() {
        if (pagamento.getValor() != null && pagamento.getValor() > 0 && pagamento.getValor() <= valorTotalDivida) {
            try {
                pagamentoService.pagarDivida(pagamento);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pagamento realizado com sucesso!"));
                prepararPagamento(); // Recalcular a dívida restante
            } catch (IllegalArgumentException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Valor de pagamento inválido"));
        }
    }
}