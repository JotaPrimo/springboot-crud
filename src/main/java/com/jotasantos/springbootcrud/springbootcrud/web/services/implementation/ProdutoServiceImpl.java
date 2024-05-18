package com.jotasantos.springbootcrud.springbootcrud.web.services.implementation;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Produto;
import com.jotasantos.springbootcrud.springbootcrud.exceptions.EntityNotFoundException;
import com.jotasantos.springbootcrud.springbootcrud.repositories.IProdutoRepository;
import com.jotasantos.springbootcrud.springbootcrud.web.services.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return produtoRepository.
                findById(id).
                orElseThrow(() -> new EntityNotFoundException(String.format("Produto {%s} não encontrado", id)));
    }

    @Override
    public Produto save(Produto produto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
