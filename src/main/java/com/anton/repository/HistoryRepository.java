package com.anton.repository;

import com.anton.model.Feedback;
import com.anton.model.History;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HistoryRepository {
    private final SessionFactory sessionFactory;

    public HistoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public History getHistoryById(final Long id){
        return sessionFactory.getCurrentSession().get(History.class, id);
    }

    public List<History> getAllHistories(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM history");
        List<History> list = (List<History>) query.getResultList();
        return list;
    }

    public void deleteHistory(Long id) {
        History history = getHistoryById(id);
        sessionFactory.getCurrentSession().delete(history);
    }

    public void addHistory(History history) {
        sessionFactory.getCurrentSession().saveOrUpdate(history);
    }
}
