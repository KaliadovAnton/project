package com.anton.controller;

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

    @GetMapping()
    public ResponseEntity<List<Ticket>> getListOfTickets(){
        List<Ticket> tickets = ticketService.getListOfTickets();
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

    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(ticketService.getTicketById(id));
    }
}
