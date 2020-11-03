package com.anton.service;

import com.anton.dto.RegisterRequest;
import com.anton.model.NotificationEmail;
import com.anton.model.Role;
import com.anton.model.User;
import com.anton.model.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class LoginService {

    final private PasswordEncoder passwordEncoder;
    final private UserService userService;
    final private MailService mailService;
    private final VerificationTokenService tokenService;

    @Autowired
    public LoginService(PasswordEncoder passwordEncoder, UserService userService, MailService mailService, VerificationTokenService tokenService){
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.mailService = mailService;
        this.tokenService = tokenService;
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
        mailService.sendMail(new NotificationEmail("Acctivate your account",
                user.getEmail(),
                "click on this: http://localhost:8080/api/login/signup/?token="+token));
    }

    private String generateVerificationToken(User user){
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUser(user.getEmail());
        verificationToken.setToken(token);
        tokenService.addVerificationToken(verificationToken);
        return token;
    }
}
