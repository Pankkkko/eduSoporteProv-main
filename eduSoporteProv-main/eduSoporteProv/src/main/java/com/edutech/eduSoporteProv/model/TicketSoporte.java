package com.edutech.eduSoporteProv.model;

import java.time.LocalDateTime;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public abstract class TicketSoporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, nullable = false)
    private String titulo;

    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(updatable = true)
    private LocalDateTime fechaActualizacion;

    @Column(length = 500, nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoTicket estadoTicket = EstadoTicket.CREADO;


}
