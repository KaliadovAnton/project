package com.anton.repository;


import com.anton.model.RefreshToken;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class RefreshTokenRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public RefreshToken save(RefreshToken refreshToken) {
        sessionFactory.getCurrentSession().persist(refreshToken);
        return refreshToken;
    }
    public Optional<RefreshToken> findByToken(String token){
        return Optional.ofNullable(sessionFactory.getCurrentSession().createQuery("FROM RefreshToken r WHERE r.token =:token", RefreshToken.class).setParameter("token", token)
                .uniqueResultOptional().orElseThrow(NoResultException::new));
    }

    public void deleteByToken(String token){
        sessionFactory.getCurrentSession().delete(findByToken(token));
    }
}
