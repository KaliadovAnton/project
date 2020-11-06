package com.anton.dto;

import java.util.Date;

public class CommentDTO {

    private Long userId;
    private String text;
    private Date date;
    private Long ticket;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTicketId() {
        return ticket;
    }

    public void setTicketId(Long ticket) {
        this.ticket = ticket;
    }
}
