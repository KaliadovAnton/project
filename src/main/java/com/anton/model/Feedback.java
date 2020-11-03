package com.anton.model;


import java.util.List;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FEEDBACK")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private List<User> user;
    private int rate;
    private Date date;
    private String text;
    @ManyToMany
    @JoinColumn(name="ticket_id", referencedColumnName = "id")
    private List<Ticket> ticket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
