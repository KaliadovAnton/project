package com.anton.repository;

import com.anton.model.Attachment;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    public Attachment getAttachmentById(final Long id){
        return sessionFactory.getCurrentSession().get(Attachment.class, id);
    }

    public List<Attachment> getAllAttachments(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM ATTACHMENT");
        List<Attachment> list = (List<Attachment>) query.getResultList();
        return list;
    }

    public void deleteAttachment(Long id) {

    }

    public void addAttachment(Attachment attachment) {
        sessionFactory.getCurrentSession().save(attachment);
    }
}
