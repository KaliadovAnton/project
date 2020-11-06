package com.anton.repository;

import com.anton.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserRepository {
    private final SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Optional<User> getUserById(final Long id){
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(User.class, id));
    }

    public List<User> getAllUsers(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User;");
        List<User> list = (List<User>) query.getResultList();
        return list;
    }

    public void deleteUser(Long id) {
        User user = getUserById(id).orElseThrow(()-> new NoResultException("Theres no user with id "+id));
        sessionFactory.getCurrentSession().delete(user);
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    public User getUserByEmail(String email){
        return sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.email =:email", User.class).setParameter("email", email).uniqueResultOptional().orElseThrow(()->new NoResultException());
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }
}
