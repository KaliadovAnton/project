package com.anton.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @Email
    private String email;
    @NotBlank
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(@Email String email, @NotBlank String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
