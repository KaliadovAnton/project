package com.anton.model;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "created_on")
    private java.sql.Timestamp createdOn;
    @Column(name = "desired_resolution_date")
    private java.sql.Timestamp desiredResolutionDate;



    @ManyToOne
    @JoinColumn(name="assignee_id", referencedColumnName = "id")
    private User assignee;
    @ManyToOne
    @JoinColumn(name="owner_id", referencedColumnName = "id")
    private User owners;
    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;
    @ManyToOne
    @JoinColumn(name="approver_id", referencedColumnName = "id")
    private User approvers;
    @Column(name = "state_id")
    private State stateId;
    @Column(name =  "urgency_id")
    private Urgency urgencyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* public Date getCreatedOn() {
        return createdOn;
    }*/

    /*public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getDesiredResolutionDate() {
        return desiredResolutionDate;
    }

    public void setDesiredResolutionDate(Date desiredResolutionDate) {
        this.desiredResolutionDate = desiredResolutionDate;
    }*/

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Timestamp getDesiredResolutionDate() {
        return desiredResolutionDate;
    }

    public User getAssignee() {
        return assignee;
    }

    public User getOwners() {
        return owners;
    }

    public Category getCategory() {
        return category;
    }

    public User getApprovers() {
        return approvers;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public Urgency getUrgencyId() {
        return urgencyId;
    }

    public void setUrgencyId(Urgency urgencyId) {
        this.urgencyId = urgencyId;
    }
}
