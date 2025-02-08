package com.example.tprime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tprime.model.Cliente;
import com.example.tprime.model.Compra;
import com.example.tprime.model.Pagamento;
import com.example.tprime.repository.IClienteRepository;
import com.example.tprime.repository.ICompraRepository;
import com.example.tprime.repository.IPagamentoRepository;

import javax.transaction.Transactional;

import java.util.*;

@Transactional
@Service
public class PagamentoService {
    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ICompraRepository compraRepository;

    @Autowired
    private IPagamentoRepository repository;

    //Método utilizado para o cliente realizar o pagamento da compra realizada ou pagar sua dívida 
    public void pagarCompra(Long clienteId, Long compraId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Compra compra = compraRepository.findById(compraId).orElseThrow(() -> new RuntimeException("Compra não encontrada"));

        if (!compra.isSituacao()) { 
            compra.setSituacao(true); 
            compraRepository.save(compra); 
            cliente.setDivida(cliente.getDivida() - compra.getValor()); 
            clienteRepository.save(cliente); 
        }
    }

    public void salvar(Pagamento pagamento) {
        repository.save(pagamento);
    }

    public void editar(Pagamento pagamento) {
        repository.save(pagamento);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Optional<Pagamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Pagamento> buscarTodos() {
        return repository.findAll();
    }

}
