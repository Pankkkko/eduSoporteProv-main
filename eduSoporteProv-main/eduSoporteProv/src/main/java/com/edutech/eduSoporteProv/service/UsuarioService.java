package com.edutech.eduSoporteProv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.eduSoporteProv.model.Usuario;
import com.edutech.eduSoporteProv.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarxId(int id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> actualizarUsuario(int id, Usuario updatedUsuario) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setCorreo(updatedUsuario.getCorreo());
            usuario.setPassword(updatedUsuario.getPassword());
            usuario.setUsuario(updatedUsuario.getUsuario());
            usuario.setNombrereal(updatedUsuario.getNombrereal());
            usuario.setRolUsuario(updatedUsuario.getRolUsuario());
            return usuarioRepository.save(usuario);
        });
    }

    public boolean eliminarUsuario(int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean desactivarUsuario(int id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            Usuario actUsuario = usuario.get();
            actUsuario.setEsvisible(!actUsuario.isEsvisible());
            usuarioRepository.save(actUsuario);
            return true;
        }
        return false;
    }
}
