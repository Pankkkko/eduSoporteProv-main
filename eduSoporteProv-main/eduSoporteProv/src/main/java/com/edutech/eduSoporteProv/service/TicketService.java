package com.edutech.eduSoporteProv.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.edutech.eduSoporteProv.model.TicketSoporte;
import com.edutech.eduSoporteProv.repository.TicketRepository;

public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public TicketSoporte save(TicketSoporte ticket) {
        return ticketRepository.save(ticket);
    }

    public TicketSoporte findxId(int id) {
        return ticketRepository.findxId(id);
    }

    public TicketSoporte deletexId(int id) {
        return ticketRepository.deletexId(id);
    }
}
