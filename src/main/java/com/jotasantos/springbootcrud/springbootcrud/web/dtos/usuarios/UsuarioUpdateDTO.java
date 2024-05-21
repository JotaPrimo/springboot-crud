package com.jotasantos.springbootcrud.springbootcrud.web.dtos.usuarios;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UsuarioUpdateDTO(
        @NotBlank(message = "Nome é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Nome deve ter entre {min} e {max} caracteres")
        String nome,

        @NotBlank(message = "Email é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Email deve ter entre {min} e {max} caracteres")
        String email
) {
    public static Usuario toEntity(UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioUpdateDTO.nome);
        usuario.setEmail(usuarioUpdateDTO.email);
        usuario.setUpdatedAt(LocalDateTime.now());
        return usuario;
    }
}
