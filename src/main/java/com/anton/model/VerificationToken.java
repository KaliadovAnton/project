package com.anton.model;

import javax.persistence.*;

@Entity
@Table
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @Column(name = "token")
    private String token;

    public String getEmail() {
        return email;
    }

    public void setUser(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }
}
