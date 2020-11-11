package com.anton.service;

import com.anton.dto.AuthenticationResponse;
import com.anton.dto.LoginRequest;
import com.anton.dto.RefreshTokenRequest;
import com.anton.dto.RegisterRequest;
import com.anton.model.NotificationEmail;
import com.anton.model.User;
import com.anton.model.VerificationToken;
import com.anton.security.JWTProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.time.Instant;
import java.util.UUID;

@Service
public class LoginService {

    final private PasswordEncoder passwordEncoder;
    final private UserService userService;
    final private MailService mailService;
    private final VerificationTokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final JWTProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    @Autowired
    public LoginService(PasswordEncoder passwordEncoder, UserService userService, MailService mailService, VerificationTokenService tokenService, AuthenticationManager authenticationManager, JWTProvider jwtProvider, RefreshTokenService refreshTokenService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.mailService = mailService;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.refreshTokenService = refreshTokenService;
    }

    @Transactional
    public void signup(RegisterRequest registerRequest){
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setRole(registerRequest.getRole());
        user.setEnable(false);
        userService.addUser(user);
        String token = generateVerificationToken(user);
        mailService.sendMail(new NotificationEmail("Activate your account",
                user.getEmail(),
                "click on this: http://localhost:8080/api/login/signup/"+token));
    }

    private String generateVerificationToken(User user){
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUser(user.getEmail());
        verificationToken.setToken(token);
        tokenService.addVerificationToken(verificationToken);
        return token;
    }

    public void verifyAccount(String token) throws Throwable {
        VerificationToken verificationToken = tokenService.getToken(token);
        verifyAndAddUser(verificationToken);
    }

    @Transactional
    public void verifyAndAddUser(VerificationToken token){
        User user = userService.getUserByEmail(token.getEmail());
        user.setEnable(true);
        userService.updateUser(user);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return new AuthenticationResponse(token,
                refreshTokenService.generateRefreshToken().getToken(),
                Instant.now().plusMillis(jwtProvider.getJWTExpirationInMillis()),
                loginRequest.getEmail());
    }

    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtProvider.generateTokenWithUserName(refreshTokenRequest.getUsername());
        return new AuthenticationResponse(token,refreshTokenRequest.getRefreshToken(),Instant.now().plusMillis(jwtProvider.getJWTExpirationInMillis()), refreshTokenRequest.getUsername());

    }

    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }
}
