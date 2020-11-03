package com.anton.repository;

import com.anton.model.Ticket;
import com.anton.model.VerificationToken;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class VerificationTokenRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<VerificationToken> getListOfTokens(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM VerificationToken");
        List<VerificationToken> list = (List<VerificationToken>) query.getResultList();
        return list;
    }

    public void addVerificationToken(VerificationToken token){
        sessionFactory.getCurrentSession().persist(token);
    }

}
