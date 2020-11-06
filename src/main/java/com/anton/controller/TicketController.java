package com.anton.controller;

import com.anton.converter.TicketConverter;
import com.anton.dto.TicketDTO;
import com.anton.model.Ticket;
import com.anton.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketConverter ticketConverter;

    @GetMapping()
    public ResponseEntity<List<TicketDTO>> getListOfTickets(){
        List<TicketDTO> tickets = ticketConverter.getListOfTicketsDTO();
        return ResponseEntity.ok().body(tickets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id){
        ticketService.deleteTicket(id);
        return ResponseEntity.ok().body("");
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Ticket ticket){
        ticketService.addTicket(ticket);
        return ResponseEntity.ok().body("");
    }

    @PutMapping("/{id}")
    public void updateTicket(@PathVariable("id") Long id, Ticket ticket){
        ticketService.updateTicket(id, ticket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(ticketConverter.getTicketDTO(id));
    }
}
