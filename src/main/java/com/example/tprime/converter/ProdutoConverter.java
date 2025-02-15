package com.example.tprime.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import com.example.tprime.model.Produto;
import com.example.tprime.service.ProdutoService;

@Component
@ApplicationScope
@FacesConverter(value = "produtoConverter")
public class ProdutoConverter implements Converter{

    //Cria uma instancia do service para ter acesso ao metodo porId
    @Autowired
    private ProdutoService produtoService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Produto retorno = null;

        //if(valor != null && !"".equals(valor)){
        if(value != null && ! value.isEmpty()){
            retorno = produtoService.buscarPorId(Long.valueOf(value));
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        if(o != null){
            Produto produto = (Produto) o;
            return produto.getId() == null ? null : produto.getId().toString();
        }
        return null;
    }
    
}

