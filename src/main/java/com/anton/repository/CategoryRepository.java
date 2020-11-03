package com.anton.repository;

import com.anton.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryRepository {
    private final SessionFactory sessionFactory;

    public CategoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Category getCategoryById(final Long id){
        return sessionFactory.getCurrentSession().get(Category.class, id);
    }

    public List<Category> getAllCategories(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM CATEGORY");
        return (List<Category>) query.getResultList();
    }

    public void deleteCategory(Long id) {
        Category category = getCategoryById(id);
        sessionFactory.getCurrentSession().delete(category);
    }
}
