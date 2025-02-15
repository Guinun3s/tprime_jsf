package com.example.tprime.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tprime.model.Compra;

public interface ICompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByClienteId(Long clienteId);
}
