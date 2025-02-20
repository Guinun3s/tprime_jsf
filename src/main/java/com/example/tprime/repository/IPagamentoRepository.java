package com.example.tprime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tprime.model.Pagamento;

public interface IPagamentoRepository extends JpaRepository<Pagamento, Long> {

    List<Pagamento> findByClienteId(Long clienteId);

}
