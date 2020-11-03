package com.anton.repository;

import com.anton.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class TicketRepository {
    private final SessionFactory sessionFactory;

    public TicketRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Ticket getTicketById(final Long id){
        return sessionFactory.getCurrentSession().get(Ticket.class, id);
    }

    public List<Ticket> getAllTickets(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Ticket");
        List<Ticket> list = (List<Ticket>) query.getResultList();
        return list;
    }

    public void addTicket(Ticket ticket){
        sessionFactory.getCurrentSession().persist(ticket);
    }

    public void  updateTicket(Ticket ticket){
        sessionFactory.getCurrentSession().saveOrUpdate(ticket);
    }

    public void deleteTicket(Long id) {
        Ticket ticket = getTicketById(id);
        sessionFactory.getCurrentSession().delete(ticket);
    }
}
