package com.example.tprime.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.tprime.model.Compra;
import com.example.tprime.service.CompraService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class ConsultaCompraBean {
    @Getter
    private List<Compra> compras;

    @Getter @Setter
    private Compra compraSelecionado;

    @Autowired
    private CompraService compraService;

    @PostConstruct
    public void init(){
        compras = compraService.buscarTodos();
    }

    public void excluir(){
         FacesContext context = FacesContext.getCurrentInstance();
        //remove a nd do banco de dados
        compraService.excluir(compraSelecionado.getId());
            context.addMessage(null, new FacesMessage("Exclusão", "Compra excluído com sucesso."));
            //consultar();
            compras = compraService.buscarTodos();
    }
    
}
