package com.example.tprime.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tprime.model.Cliente;
import com.example.tprime.repository.IClienteRepository;
import javax.transaction.Transactional;

@Transactional
@Service
public class ClienteService {
    @Autowired
    private IClienteRepository clienteRepository;

    //Método utilizado para o adicionar a dívida do cliente caso ele não pague a sua compra
    public void adicionarDivida(Long clienteId, Double valor) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setDivida(cliente.getDivida() + valor);
        clienteRepository.save(cliente);
    }

    public void salvar(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void editar(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void excluir(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente buscarPorId(Long id){
        return clienteRepository.findById(id).get();
    }

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public List<Cliente> buscarClientesComDivida() {
        return clienteRepository.findByDividaGreaterThan(0.0);
    }
}
