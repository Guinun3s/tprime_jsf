package com.example.tprime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tprime.model.Compra;
import com.example.tprime.repository.ICompraRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class CompraService {

    @Autowired
    private ICompraRepository compraRepository;

    @Autowired
    private ClienteService clienteService;
   
    public void salvar(Compra compra) {
        compraRepository.save(compra);
        clienteService.adicionarDivida(compra.getCliente().getId(), compra.getValor());
    }

    public void editar(Compra compra) {
        compraRepository.save(compra);
    }

    public void excluir(Long id) {
        compraRepository.deleteById(id);
    }

    public Compra buscarPorId(Long id) {
        return compraRepository.findById(id).get();
    }

    public List<Compra> buscarTodos() {
        return compraRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Compra> buscarComprasPorCliente(Long clienteId) {
        return compraRepository.findByClienteId(clienteId);
    }

}
