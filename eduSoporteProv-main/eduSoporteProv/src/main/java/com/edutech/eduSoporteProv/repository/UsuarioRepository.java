package com.edutech.eduSoporteProv.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.eduSoporteProv.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @SuppressWarnings("unchecked")
    
    Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Usuario findById(int id);
    
    Usuario deleteById(int id);
}