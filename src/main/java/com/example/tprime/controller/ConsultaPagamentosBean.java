package com.example.tprime.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

import com.example.tprime.model.Pagamento;
import com.example.tprime.service.PagamentoService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class ConsultaPagamentosBean implements Serializable {

    @Autowired
    private PagamentoService pagamentoService;

    @Getter @Setter
    private Long clienteId;

    @Getter
    private List<Pagamento> pagamentos;

    @PostConstruct
    public void init() {
        if (clienteId != null) {
            pagamentos = pagamentoService.buscarPagamentosPorCliente(clienteId);
        }
    }
}
