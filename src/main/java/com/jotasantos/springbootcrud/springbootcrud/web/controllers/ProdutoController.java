package com.jotasantos.springbootcrud.springbootcrud.web.controllers;

import com.jotasantos.springbootcrud.springbootcrud.core.config.ApiPath;
import com.jotasantos.springbootcrud.springbootcrud.core.entities.Produto;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoCreateDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoResponseDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos.ProdutoUpdateDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.services.interfaces.IProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiPath.PRODUTOS)
public class ProdutoController {

    @Autowired
    private IProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> index() {
        List<ProdutoResponseDTO> produtos = produtoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> findById(@PathVariable Long id) {
        ProdutoResponseDTO produto = produtoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> store(@Valid @RequestBody ProdutoCreateDTO produtoCreateDTO) {
        ProdutoResponseDTO produto = produtoService.save(produtoCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ProdutoUpdateDTO produtoUpdateDTO) {
        ProdutoResponseDTO produto = produtoService.update(id, produtoUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
