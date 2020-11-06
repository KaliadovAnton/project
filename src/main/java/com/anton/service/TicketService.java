package com.anton.service;

import com.anton.model.Ticket;
import com.anton.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Service
@Transactional
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getListOfTickets(){
        return ticketRepository.getAllTickets();
    }

    public void deleteTicket(Long id){
        ticketRepository.deleteTicket(id);
    }

    public void addTicket(Ticket ticket){
        ticketRepository.addTicket(ticket);
    }

    public void updateTicket(Long id, Ticket ticket){
        ticketRepository.updateTicket(id, ticket);
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.getTicketById(id).orElseThrow(()->new NoResultException("There s no ticket with id "+id));
    }
}
