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
import com.edutech.eduSoporteProv.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketSoporteController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketSoporte> postTicket(@RequestBody TicketSoporte ticket){
        TicketSoporte buscado = ticketService.findxId(ticket.getId());
        if (buscado == null){
            return new ResponseEntity<>(ticketService.save(ticket), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketSoporte> getTicketXid(@PathVariable int id){
        TicketSoporte buscado = ticketService.findxId(id);
        if(buscado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buscado, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketSoporte> updateTicket(@PathVariable int id, @RequestBody TicketSoporte ticket){
        TicketSoporte existente = ticketService.findxId(id);
        if (existente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existente.setDescripcion(ticket.getDescripcion());
        existente.setEstadoTicket(ticket.getEstadoTicket());
        existente.setFechaActualizacion(ticket.getFechaActualizacion());

        TicketSoporte actualizado = ticketService.save(existente);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

}
