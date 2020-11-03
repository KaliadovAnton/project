package com.anton.repository;

import com.anton.model.Feedback;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class FeedbackRepository {
    private final SessionFactory sessionFactory;

    public FeedbackRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Feedback getFeedbackById(final Long id){
        return sessionFactory.getCurrentSession().get(Feedback.class, id);
    }

    public List<Feedback> getAllFeedbacks(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Feedback");
        List<Feedback> list = (List<Feedback>) query.getResultList();
        return list;
    }

    public void deleteFeedback(Long id) {
        Feedback feedback = getFeedbackById(id);
        sessionFactory.getCurrentSession().delete(feedback);
    }

    public void addFeedback(Feedback feedback) {
        sessionFactory.getCurrentSession().saveOrUpdate(feedback);
    }
}
