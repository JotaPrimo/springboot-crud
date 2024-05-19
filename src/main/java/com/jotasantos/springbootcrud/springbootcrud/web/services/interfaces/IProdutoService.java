package com.jotasantos.springbootcrud.springbootcrud.web.services.interfaces;

import com.jotasantos.springbootcrud.springbootcrud.exceptions.EntityNotFoundException;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoCreateDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoResponseDTO;

import java.util.List;

public interface IProdutoService {

    List<ProdutoResponseDTO> findAll();

    ProdutoResponseDTO findById(Long id) throws EntityNotFoundException;

    ProdutoResponseDTO save(ProdutoCreateDTO produto);

    void delete(Long id);

    boolean existsById(Long id);

}
