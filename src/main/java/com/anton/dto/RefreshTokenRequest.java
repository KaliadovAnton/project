package com.anton.dto;

import javax.validation.constraints.NotBlank;

public class RefreshTokenRequest {
    @NotBlank
    private String refreshToken;
    private String username;

    public RefreshTokenRequest() {
    }

    public RefreshTokenRequest(@NotBlank String refreshToken, String username) {
        this.refreshToken = refreshToken;
        this.username = username;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
