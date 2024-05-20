package com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public record ProdutoResponseDTO(
        Long id,
        String descricao,
        Double preco
) {
    public static ProdutoResponseDTO from(Produto produto) {
        return new ProdutoResponseDTO(produto.getId(), produto.getDescricao(), produto.getPreco());
    }

    public static List<ProdutoResponseDTO> toListDTO(List<Produto> produtos) {
        List<ProdutoResponseDTO> produtoResponseDTOS = new ArrayList<>();
        produtos.forEach(p ->produtoResponseDTOS.add(ProdutoResponseDTO.from(p)));
        return produtoResponseDTOS;
    }

}
