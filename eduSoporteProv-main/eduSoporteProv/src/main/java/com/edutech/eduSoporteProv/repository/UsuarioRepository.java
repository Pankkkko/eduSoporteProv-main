package com.edutech.eduSoporteProv.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.eduSoporteProv.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}