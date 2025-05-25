package com.edutech.eduSoporteProv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.eduSoporteProv.model.Usuario;
import com.edutech.eduSoporteProv.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findxId(int id) {
        return usuarioRepository.findById(id);
    }

    public Usuario deletexId(int id) {
        return usuarioRepository.deleteById(id);
    }
}
