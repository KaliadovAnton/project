package com.anton.dto;

import com.anton.model.*;
import java.sql.Timestamp;

public class TicketDTO {

    private String name;
    private String description;
    private java.sql.Timestamp createdOn;
    private java.sql.Timestamp desiredResolutionDate;
    private Long assigneeId;
    private Long ownerId;
    private Category category;
    private Long approverId;
    private State stateId;
    private Urgency urgencyId;

    public TicketDTO() {
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

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getDesiredResolutionDate() {
        return desiredResolutionDate;
    }

    public void setDesiredResolutionDate(Timestamp desiredResolutionDate) {
        this.desiredResolutionDate = desiredResolutionDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getApproverId() {
        return approverId;
    }

    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }
}
