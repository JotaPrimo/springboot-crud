package com.jotasantos.springbootcrud.springbootcrud.services.interfaces;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Usuario;
import com.jotasantos.springbootcrud.springbootcrud.exceptions.EntityNotFoundException;
import com.jotasantos.springbootcrud.springbootcrud.exceptions.UsernameAlreadyExistsException;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.usuarios.UsuarioCreateDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.usuarios.UsuarioResponseDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.usuarios.UsuarioUpdateDTO;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> findAll();

    List<Usuario> findAllOrderById();

    Usuario findOrFail(Long id) throws EntityNotFoundException;

    UsuarioResponseDTO save(UsuarioCreateDTO usuarioCreateDTO) throws UsernameAlreadyExistsException;

    UsuarioResponseDTO update(Long id, UsuarioUpdateDTO usuarioUpdateDTO) throws UsernameAlreadyExistsException, EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;

    UsuarioResponseDTO ativarUsuario(Long id, UsuarioUpdateDTO usuarioUpdateDTO) throws EntityNotFoundException;

    UsuarioResponseDTO inativarUsuario(Long id, UsuarioUpdateDTO usuarioUpdateDTO) throws EntityNotFoundException;

    UsuarioResponseDTO suspenderUsuario(Long id, UsuarioUpdateDTO usuarioUpdateDTO) throws EntityNotFoundException;
}
