package com.edutech.eduSoporteProv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.eduSoporteProv.model.TicketSoporte;
import com.edutech.eduSoporteProv.repository.TicketRepository;

@Service
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
