package com.anton.model;

import java.util.List;

import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @Column(name = "created_on")
    private java.sql.Timestamp createdOn;
    @Column(name = "desired_resolution_date")
    private java.sql.Timestamp desiredResolutionDate;
    @ManyToOne(fetch = FetchType.LAZY)
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
    @Enumerated
    private State stateId;
    @Column(name =  "urgency_id")
    @Enumerated
    private Urgency urgencyId;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Attachment> attachments;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Feedback> feedbacks;
    @OneToMany(fetch = FetchType.LAZY)
    private List<History> histories;


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
