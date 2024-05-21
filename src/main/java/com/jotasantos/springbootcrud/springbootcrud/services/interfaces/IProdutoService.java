package com.jotasantos.springbootcrud.springbootcrud.services.interfaces;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Produto;
import com.jotasantos.springbootcrud.springbootcrud.exceptions.EntityNotFoundException;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoCreateDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoResponseDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoUpdateDTO;

import java.util.List;

public interface IProdutoService {

    List<ProdutoResponseDTO> findAll();

    ProdutoResponseDTO findById(Long id) throws EntityNotFoundException;

    ProdutoResponseDTO save(ProdutoCreateDTO produto);

    void delete(Long id) throws EntityNotFoundException;

    boolean existsById(Long id);

    ProdutoResponseDTO update(Long id, ProdutoUpdateDTO produto);

    Produto findByIdOrThrow(Long id) throws EntityNotFoundException;

}
