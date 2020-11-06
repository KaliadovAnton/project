package com.anton.service;

import com.anton.model.Category;
import com.anton.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public List<Category> getListOfCategories(){
        return categoryRepository.getAllCategories();
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteCategory(id);
    }

    public void addCategory(Category category) {
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.getCategoryById(id).orElseThrow(()-> new NoResultException("There is no category with id "+id));
    }
}
