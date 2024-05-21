package com.jotasantos.springbootcrud.springbootcrud.services.implementation;

import com.jotasantos.springbootcrud.springbootcrud.core.entities.Usuario;
import com.jotasantos.springbootcrud.springbootcrud.exceptions.EntityNotFoundException;
import com.jotasantos.springbootcrud.springbootcrud.exceptions.UsernameAlreadyExistsException;
import com.jotasantos.springbootcrud.springbootcrud.repositories.IUsuarioRepository;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.usuarios.UsuarioCreateDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.usuarios.UsuarioResponseDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.usuarios.UsuarioUpdateDTO;
import com.jotasantos.springbootcrud.springbootcrud.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findAllOrderById() {
        return usuarioRepository.findAllOrderById();
    }

    @Override
    public Usuario findOrFail(Long id) throws EntityNotFoundException {
        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(String.format("Produto {%s} não encontrado", id))));
        return usuario;
    }

    @Override
    public UsuarioResponseDTO save(UsuarioCreateDTO usuarioCreateDTO) throws UsernameAlreadyExistsException {
        Usuario usuarioToSave = UsuarioCreateDTO.toEntity(usuarioCreateDTO);
        Usuario usuarioSaved = usuarioRepository.save(usuarioToSave);
        return UsuarioResponseDTO.fromEntity(usuarioSaved);
    }

    @Override
    public UsuarioResponseDTO update(Long id, UsuarioUpdateDTO usuarioUpdateDTO) throws UsernameAlreadyExistsException, EntityNotFoundException {
        return null;
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {

    }

    @Override
    public UsuarioResponseDTO ativarUsuario(Long id, UsuarioUpdateDTO usuarioUpdateDTO) throws EntityNotFoundException {
        return null;
    }

    @Override
    public UsuarioResponseDTO inativarUsuario(Long id, UsuarioUpdateDTO usuarioUpdateDTO) throws EntityNotFoundException {
        return null;
    }

    @Override
    public UsuarioResponseDTO suspenderUsuario(Long id, UsuarioUpdateDTO usuarioUpdateDTO) throws EntityNotFoundException {
        return null;
    }
}
