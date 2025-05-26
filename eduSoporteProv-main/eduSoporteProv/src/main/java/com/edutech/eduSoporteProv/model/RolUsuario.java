package com.edutech.eduSoporteProv.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@MappedSuperclass
@Table(name = "rol_usuario")
public enum RolUsuario {
    USUARIO,
    ADMINISTRADOR,
    SOPORTE,
    ESTUDIANTE,
    INSTRUCTOR
}
