package com.anton.converter;

import com.anton.dto.TicketDTO;
import com.anton.model.Ticket;
import com.anton.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketConverter {

    @Autowired
    private TicketService ticketService;

    public TicketDTO getTicketDTO(Long id){
        Ticket ticket = ticketService.getTicketById(id);
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setName(ticket.getName());
        ticketDTO.setDescription(ticket.getDescription());
        ticketDTO.setCreatedOn(ticket.getCreatedOn());
        ticketDTO.setDesiredResolutionDate(ticket.getDesiredResolutionDate());
        ticketDTO.setApproverId(ticket.getApprovers().getId());
        ticketDTO.setAssigneeId(ticket.getAssignee().getId());
        ticketDTO.setOwnerId(ticket.getOwners().getId());
        ticketDTO.setCategory(ticket.getCategory());
        ticketDTO.setUrgencyId(ticket.getUrgencyId());
        ticketDTO.setStateId(ticket.getStateId());
        return ticketDTO;
    }

    public List<TicketDTO> getListOfTicketsDTO(){
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for (Ticket ticket: ticketService.getListOfTickets()){
            TicketDTO ticketDTO = new TicketDTO();
            ticketDTO.setName(ticket.getName());
            ticketDTO.setDescription(ticket.getDescription());
            ticketDTO.setCreatedOn(ticket.getCreatedOn());
            ticketDTO.setDesiredResolutionDate(ticket.getDesiredResolutionDate());
            ticketDTO.setApproverId(ticket.getApprovers().getId());
            ticketDTO.setAssigneeId(ticket.getAssignee().getId());
            ticketDTO.setOwnerId(ticket.getOwners().getId());
            ticketDTO.setCategory(ticket.getCategory());
            ticketDTO.setUrgencyId(ticket.getUrgencyId());
            ticketDTO.setStateId(ticket.getStateId());
            ticketDTOList.add(ticketDTO);
        }
        return ticketDTOList;
    }
}
