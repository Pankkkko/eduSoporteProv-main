package com.edutech.eduSoporteProv.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@MappedSuperclass
@Table(name = "estado_ticket")
public enum EstadoTicket {
    CREADO,
    EN_PROCESO,
    RESUELTO
}
