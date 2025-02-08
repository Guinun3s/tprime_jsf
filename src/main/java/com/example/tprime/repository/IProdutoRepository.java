package com.example.tprime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tprime.model.Produto;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {

}
