package com.example.tprime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tprime.model.Produto;
import com.example.tprime.repository.IProdutoRepository;

import javax.transaction.Transactional;

import java.util.*;

@Transactional
@Service
public class ProdutoService {
    @Autowired
    private IProdutoRepository repository;

    public void salvar(Produto produto) {
        repository.save(produto);
    }

    public void editar(Produto produto) {
        repository.save(produto);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Produto> buscarTodos() {
        return repository.findAll();
    }

}
