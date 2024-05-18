package com.jotasantos.springbootcrud.springbootcrud.repositories;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IProdutoRepository extends JpaRepository<Produto, Long> {
}
