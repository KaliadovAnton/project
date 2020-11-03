package com.anton.controller;

import com.anton.dto.RegisterRequest;
import com.anton.model.User;
import com.anton.model.VerificationToken;
import com.anton.service.LoginService;
import com.anton.service.UserService;
import com.anton.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;
    @Autowired
    private VerificationTokenService tokenService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){
        loginService.signup(registerRequest);
        return new ResponseEntity<>("Registered successfully", HttpStatus.OK);
    }

    @GetMapping("/signup/*")
    public ResponseEntity<String> addUser(@RequestParam("token") String token){
        System.out.println(token);
        VerificationToken verificationToken = tokenService.getToken(token);
        if(verificationToken!=null){
            User user = userService.getUserByEmail(verificationToken.getEmail());
            user.setEnable(true);
            userService.updateUser(user);
            return new ResponseEntity<>("User registered", HttpStatus.OK);
        }
        return new ResponseEntity<>("User id not registered", HttpStatus.OK);
    }
}
