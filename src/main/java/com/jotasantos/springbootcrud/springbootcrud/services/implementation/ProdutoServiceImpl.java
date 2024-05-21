package com.jotasantos.springbootcrud.springbootcrud.services.implementation;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Produto;
import com.jotasantos.springbootcrud.springbootcrud.exceptions.EntityNotFoundException;
import com.jotasantos.springbootcrud.springbootcrud.repositories.IProdutoRepository;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoCreateDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoResponseDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoUpdateDTO;
import com.jotasantos.springbootcrud.springbootcrud.services.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Override
    public List<ProdutoResponseDTO> findAll() {
        List<Produto> produtos = this.findAllSortedById();
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
    @Transactional
    public ProdutoResponseDTO save(ProdutoCreateDTO produtoCreateDTO) {
        Produto produto = ProdutoCreateDTO.from(produtoCreateDTO);
        Produto produtoSaved = produtoRepository.save(produto);
        return ProdutoResponseDTO.from(produtoSaved);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Produto produtoDelete = this.findByIdOrThrow(id);
        produtoRepository.delete(produtoDelete);
    }

    @Override
    @Transactional
    public ProdutoResponseDTO update(Long id, ProdutoUpdateDTO produtoUpdateDTO) {
        Produto produto = this.findByIdOrThrow(id);
        Produto produtoUpdate = ProdutoUpdateDTO.entityFromDTO(produto, produtoUpdateDTO);
        Produto produtoSaved = produtoRepository.save(produtoUpdate);
        return ProdutoResponseDTO.from(produtoSaved);
    }

    @Override
    public Produto findByIdOrThrow(Long id) throws EntityNotFoundException {
        return this.produtoRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Registro não encontrado %s", id)));
    }

    public List<Produto> findAllSortedById() {
        return this.produtoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

}
