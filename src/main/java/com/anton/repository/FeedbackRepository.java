package com.anton.repository;

import com.anton.model.Feedback;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
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

    public Optional<Feedback> getFeedbackById(final Long id){
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Feedback.class, id));
    }

    public List<Feedback> getAllFeedbacks(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Feedback");
        List<Feedback> list = (List<Feedback>) query.getResultList();
        return list;
    }

    public void deleteFeedback(Long id) {
        Feedback feedback = getFeedbackById(id).orElseThrow(()->new NoResultException("There s no feedback with id " + id));
        sessionFactory.getCurrentSession().delete(feedback);
    }

    public void addFeedback(Feedback feedback) {
        sessionFactory.getCurrentSession().saveOrUpdate(feedback);
    }

    public void updateFeedback(Long id, Feedback feedback) {
        feedback.setId(id);
        deleteFeedback(id);
        sessionFactory.getCurrentSession().persist(feedback);
    }
}
