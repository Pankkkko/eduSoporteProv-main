package com.edutech.eduSoporteProv.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.edutech.eduSoporteProv.model.Usuario;
import com.edutech.eduSoporteProv.repository.UsuarioRepository;

public class GestionRolesService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findxId(int id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
