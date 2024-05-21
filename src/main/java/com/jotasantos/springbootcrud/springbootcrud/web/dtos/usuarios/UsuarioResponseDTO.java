package com.jotasantos.springbootcrud.springbootcrud.web.dtos.usuarios;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Usuario;
import com.jotasantos.springbootcrud.springbootcrud.enums.EnumStatusUsuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record UsuarioResponseDTO(
        Long id,

        String nome,

        String email,

        EnumStatusUsuario statusUsuario,

        LocalDateTime createdAt,

        LocalDateTime updatedAt
) {

    public static UsuarioResponseDTO fromEntity(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getStatusUsuario(), usuario.getCreatedAt(), usuario.getUpdatedAt());
    }

    public static List<UsuarioResponseDTO> convertList(List<Usuario> usuarios) {
        List<UsuarioResponseDTO> usuarioResponseDTOS = new ArrayList<>();
        usuarios.forEach(usuario -> usuarioResponseDTOS.add(fromEntity(usuario)));
        return usuarioResponseDTOS;
    }

}
