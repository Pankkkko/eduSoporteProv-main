package com.edutech.eduSoporteProv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")

public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String correo;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false, unique = true)
    private String usuario;

    @Column(length = 50, nullable = false)
    private String nombrereal;

    @Enumerated(EnumType.STRING)
    private RolUsuario rolUsuario = RolUsuario.USUARIO;

    @Column(nullable = false)
    private boolean esvisible = true; // Por defecto, el usuario está activo

}

