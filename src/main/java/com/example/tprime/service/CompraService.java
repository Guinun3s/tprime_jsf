package com.example.tprime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tprime.model.Compra;
import com.example.tprime.repository.ICompraRepository;

import javax.transaction.Transactional;

import java.util.*;

@Transactional
@Service
public class CompraService {

    @Autowired
    private ICompraRepository compraRepository;

   
    public void salvar(Compra compra) {
        compraRepository.save(compra);
    }

    public void editar(Compra compra) {
        compraRepository.save(compra);
    }

    public void excluir(Long id) {
        compraRepository.deleteById(id);
    }

    public Optional<Compra> buscarPorId(Long id) {
        return compraRepository.findById(id);
    }

    public List<Compra> buscarTodos() {
        return compraRepository.findAll();
    }

}
