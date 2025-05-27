package com.edutech.eduSoporteProv.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.eduSoporteProv.model.TicketSoporte;
import com.edutech.eduSoporteProv.repository.TicketRepository;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketSoporte crearTicket(TicketSoporte ticket) {
        return ticketRepository.save(ticket);
    }

    public Optional<TicketSoporte> buscarxId(int id) {
        return ticketRepository.findById(id);
    }

    public Optional<TicketSoporte> actualizarTicket(int id, TicketSoporte updatedTicket) {
        return ticketRepository.findById(id).map(ticket -> {
            ticket.setDescripcion(updatedTicket.getDescripcion());
            ticket.setEstadoTicket(updatedTicket.getEstadoTicket());
            ticket.setFechaActualizacion(updatedTicket.getFechaActualizacion());
            return ticketRepository.save(ticket);
        });

    }

    public boolean eliminarTicket(int id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
