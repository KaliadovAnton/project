package com.anton.service;

import com.anton.model.VerificationToken;
import com.anton.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VerificationTokenService {

    @Autowired
    private VerificationTokenRepository repository;

    public List<VerificationToken> getListOfTokens(){
        return repository.getListOfTokens();
    }

    public void addVerificationToken(VerificationToken token){
        repository.addVerificationToken(token);
    }

    public VerificationToken getToken(String token){
        for(VerificationToken verificationToken :getListOfTokens()){
            if(verificationToken.getToken().equals(token)) {
                return verificationToken;
            }
        }
        return null;
    }
}
