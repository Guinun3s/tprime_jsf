package com.example.tprime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tprime.model.Pagamento;

public interface IPagamentoRepository extends JpaRepository<Pagamento, Long> {

}
