package com.anton.controller;

import com.anton.dto.AuthenticationResponse;
import com.anton.dto.LoginRequest;
import com.anton.dto.RefreshTokenRequest;
import com.anton.dto.RegisterRequest;
import com.anton.model.VerificationToken;
import com.anton.service.LoginService;
import com.anton.service.RefreshTokenService;
import com.anton.service.UserService;
import com.anton.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.List;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;
    @Autowired
    private VerificationTokenService tokenService;
    @Autowired
    private RefreshTokenService refreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody RegisterRequest registerRequest, final BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity<>("User is not registered", HttpStatus.OK);
        }
        loginService.signup(registerRequest);
        return new ResponseEntity<>("Registered successfully", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/signup/{token}")
    public ResponseEntity<String> addUser(@PathVariable String token) throws Throwable {
        System.out.println("hello");
        loginService.verifyAccount(token);
        return new ResponseEntity<>("Account activated", HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@Valid @RequestBody LoginRequest loginRequest) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        return loginService.login(loginRequest);
    }

    @GetMapping("/token")
    public ResponseEntity<List<VerificationToken>> getListOfUsers(){
        List<VerificationToken> tokens = tokenService.getListOfTokens();
        return ResponseEntity.ok().body(tokens);
    }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        return loginService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Token deleted");
    }
}
