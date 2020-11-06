package com.anton.repository;

import com.anton.model.User;
import com.anton.model.VerificationToken;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

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

    public Optional<VerificationToken> getVerificationTokenByTokenText(String token) throws Throwable {
        System.out.println("Hello from repository token");
        return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery("FROM VerificationToken t WHERE t.token =:token", VerificationToken.class)
                .setParameter("token", token).getResultList().get(0));
    }

}
