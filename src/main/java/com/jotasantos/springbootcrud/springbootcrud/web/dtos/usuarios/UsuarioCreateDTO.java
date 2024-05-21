package com.jotasantos.springbootcrud.springbootcrud.web.dtos.usuarios;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Usuario;
import com.jotasantos.springbootcrud.springbootcrud.enums.EnumStatusUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioCreateDTO(
        @NotBlank(message = "Nome é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Nome deve ter entre {min} e {max} caracteres")
        String nome,

        @NotBlank(message = "Email é um campo obrigatório")
        @Size(min = 5, max = 250, message = "Email deve ter entre {min} e {max} caracteres")
        String email,

        @NotNull(message = "Informe o statusUsuario do usúario")
        EnumStatusUsuario statusUsuario
) {
    public static Usuario toEntity(UsuarioCreateDTO usuarioCreateDTO) {
        return new Usuario(usuarioCreateDTO.nome, usuarioCreateDTO.email, usuarioCreateDTO.statusUsuario);
    }
}
