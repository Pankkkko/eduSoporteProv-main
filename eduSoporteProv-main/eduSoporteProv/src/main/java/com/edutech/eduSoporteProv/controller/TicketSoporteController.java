package com.edutech.eduSoporteProv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.eduSoporteProv.model.TicketSoporte;
import com.edutech.eduSoporteProv.repository.TicketRepository;
import com.edutech.eduSoporteProv.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketSoporteController {
    @Autowired
    private TicketRepository ticketRepository;

    private final TicketService ticketService;

    @Autowired
    public TicketSoporteController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<TicketSoporte> crearTicket(@RequestBody TicketSoporte ticket) {
        TicketSoporte nuevoTicket = ticketService.crearTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTicket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketSoporte> buscarxId(@PathVariable int id) {
        return ticketService.buscarxId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketSoporte> actualizarTicket(@PathVariable int id, @RequestBody TicketSoporte updatedTicket) {
        return ticketService.actualizarTicket(id, updatedTicket)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
