package com.example.tprime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tprime.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
