package com.edutech.eduSoporteProv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<TicketSoporte> crearTicket(@RequestBody TicketSoporte ticketSoporte) {
        TicketSoporte nuevoTicket = ticketService.crearTicket(ticketSoporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTicket);
    }

    @GetMapping
    public List<TicketSoporte> listarTickets() {
        return ticketRepository.findAll();
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTicket(@PathVariable int id) {
        if (ticketService.eliminarTicket(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
