package com.jotasantos.springbootcrud.springbootcrud.web.dtos.produtos;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Produto;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record ProdutoCreateDTO(

        @NotBlank(message = "Informe a descrição do produto")
        @Size(min = 5, max = 250, message = "A descrição deve ter entre {min} e {max} caracteres")
        String descricao,

        @NotNull(message = "Informe o preço")
        @DecimalMin(value = "0.1", inclusive = false, message = "O preço deve ser maior que zero")
        @DecimalMax(value = "1000000.00", inclusive = false, message = "O preço deve ser inferior que 1 milhão")
        @Digits(integer = 10, fraction = 2, message = "O preço deve ser um valor monetário válido")
        Double preco) {

        public static Produto from(ProdutoCreateDTO produtoCreateDTO) {
                return new Produto(produtoCreateDTO.descricao(), produtoCreateDTO.preco(), LocalDateTime.now());
        }
}
