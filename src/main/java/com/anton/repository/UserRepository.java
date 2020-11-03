package com.anton.repository;

import com.anton.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserRepository {
    private final SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User getUserById(final Long id){
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List<User> getAllUsers(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User;");
        List<User> list = (List<User>) query.getResultList();
        return list;
    }

    public void deleteUser(Long id) {
        User user = getUserById(id);
        sessionFactory.getCurrentSession().delete(user);
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    public User getUserByEmail(String email){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User where email = '" + email+"';");
        return (User) query.getSingleResult();
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}
