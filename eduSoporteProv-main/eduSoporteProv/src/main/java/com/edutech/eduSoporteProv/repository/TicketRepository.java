package com.edutech.eduSoporteProv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.eduSoporteProv.model.TicketSoporte;

public interface TicketRepository extends JpaRepository<TicketSoporte, Integer> {
    
}
