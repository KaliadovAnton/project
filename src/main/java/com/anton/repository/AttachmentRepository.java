package com.anton.repository;

import com.anton.model.Attachment;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Optional;
import java.util.List;

@Repository
@Transactional
public class AttachmentRepository {
    private final SessionFactory sessionFactory;

    public AttachmentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Optional<Attachment> getAttachmentById(final Long id){
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Attachment.class, id));
    }

    public List<Attachment> getAllAttachments(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM ATTACHMENT");
        List<Attachment> list = (List<Attachment>) query.getResultList();
        return list;
    }

    public void deleteAttachment(Long id) {
        Attachment attachment = getAttachmentById(id).orElseThrow(()->new NoResultException("There is no attachment with id "+id));
        sessionFactory.getCurrentSession().delete(attachment);
    }

    public void addAttachment(Attachment attachment) {
        sessionFactory.getCurrentSession().persist(attachment);
    }

    public void updateAttachment(Long id, Attachment attachment) {
        attachment.setId(id);
        deleteAttachment(id);
        sessionFactory.getCurrentSession().persist(attachment);
    }
}
