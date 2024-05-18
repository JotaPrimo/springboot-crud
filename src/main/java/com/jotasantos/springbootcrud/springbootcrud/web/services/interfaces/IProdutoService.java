package com.jotasantos.springbootcrud.springbootcrud.web.services.interfaces;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Produto;

import java.util.List;

public interface IProdutoService {

    List<Produto> findAll();

    Produto findById(Long id);

    Produto save(Produto produto);

    void delete(Long id);

    boolean existsById(Long id);

}
