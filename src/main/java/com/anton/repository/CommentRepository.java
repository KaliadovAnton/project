package com.anton.repository;

import com.anton.model.Attachment;
import com.anton.model.Category;
import com.anton.model.Comment;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CommentRepository {
    private final SessionFactory sessionFactory;

    public CommentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Optional<Comment> getCommentById(final Long id){
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Comment.class, id));
    }

    public List<Comment> getAllComments(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Comment");
        List<Comment> list = (List<Comment>) query.getResultList();
        return list;
    }

    public void deleteComment(Long id) {
        Comment comment = getCommentById(id).orElseThrow(()->new NoResultException("No comment with id "+id));
        sessionFactory.getCurrentSession().delete(comment);
    }

    public void addComment(Comment comment) {
        sessionFactory.getCurrentSession().persist(comment);
    }

    public void updateComment(Long id, Comment comment) {
        comment.setId(id);
        deleteComment(id);
        sessionFactory.getCurrentSession().persist(comment);
    }
}
