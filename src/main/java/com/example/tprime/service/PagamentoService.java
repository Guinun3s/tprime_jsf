package com.example.tprime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tprime.model.Cliente;
import com.example.tprime.model.Compra;
import com.example.tprime.model.Pagamento;
import com.example.tprime.repository.ICompraRepository;
import com.example.tprime.repository.IPagamentoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PagamentoService {

    @Autowired
    private IPagamentoRepository pagamentoRepository;

    @Autowired
    private ICompraRepository compraRepository;

    @Autowired
    private ClienteService clienteService;

    public void pagarDivida(Pagamento pagamento) {
        Cliente cliente = clienteService.buscarPorId(pagamento.getCliente().getId());
        Compra compra = compraRepository.findById(pagamento.getCompra().getId()).orElseThrow(() -> new RuntimeException("Compra não encontrada"));

        if (cliente != null && compra != null && pagamento.getValor() != null && pagamento.getValor() > 0 && pagamento.getValor() <= compra.getValor()) {
            pagamento.setCliente(cliente);
            pagamento.setCompra(compra);
            pagamento.setDataPagamento(new Date());

            pagamentoRepository.save(pagamento);

            // Atualizar a dívida do cliente
            cliente.setDivida(cliente.getDivida() - pagamento.getValor());
            clienteService.salvar(cliente);
        } else {
            throw new IllegalArgumentException("Dados de pagamento inválidos");
        }
    }

    public List<Pagamento> buscarPagamentosPorCliente(Long clienteId) {
        return pagamentoRepository.findByClienteId(clienteId);
    }

    public void salvar(Pagamento pagamento) {
        pagamentoRepository.save(pagamento);
    }

    public void editar(Pagamento pagamento) {
        pagamentoRepository.save(pagamento);
    }

    public void excluir(Long id) {
        pagamentoRepository.deleteById(id);
    }

    public Optional<Pagamento> buscarPorId(Long id) {
        return pagamentoRepository.findById(id);
    }

    public List<Pagamento> buscarTodos() {
        return pagamentoRepository.findAll();
    }

}
