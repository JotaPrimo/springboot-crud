package com.jotasantos.springbootcrud.springbootcrud.web.services.implementation;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Produto;
import com.jotasantos.springbootcrud.springbootcrud.exceptions.EntityNotFoundException;
import com.jotasantos.springbootcrud.springbootcrud.repositories.IProdutoRepository;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoCreateDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoResponseDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.services.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Override
    public List<ProdutoResponseDTO> findAll() {
        List<Produto> produtos = produtoRepository.findAll();
        return ProdutoResponseDTO.toListDTO(produtos);
    }

    @Override
    public ProdutoResponseDTO findById(Long id) {

        Optional<Produto> optionalProduto = produtoRepository.findById(id);

        if (optionalProduto.isPresent()) {
            return ProdutoResponseDTO.from(optionalProduto.get());
        }

        throw new EntityNotFoundException(String.format("Produto {%s} não encontrado", id));
    }

    @Override
    public ProdutoResponseDTO save(ProdutoCreateDTO produto) {
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
