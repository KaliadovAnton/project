package com.anton.repository;

import com.anton.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CategoryRepository {
    private final SessionFactory sessionFactory;

    public CategoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Optional<Category> getCategoryById(final Long id){
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Category.class, id));
    }

    public List<Category> getAllCategories(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM CATEGORY");
        return (List<Category>) query.getResultList();
    }

    public void deleteCategory(Long id) {
        Category category = getCategoryById(id).orElseThrow(()->new NoResultException("There is no category with id "+id));
        sessionFactory.getCurrentSession().delete(category);
    }
}
