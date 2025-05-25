package com.edutech.eduSoporteProv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.eduSoporteProv.model.RolUsuario;

public interface GestionRolesRepository extends JpaRepository<RolUsuario, Integer> {

    RolUsuario findById(int id);

    
}
