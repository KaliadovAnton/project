package com.anton.controller;

import com.anton.model.Category;
import com.anton.model.Ticket;
import com.anton.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<Category>> getListOfCategories(){
        List<Category> tickets = categoryService.getListOfCategories();
        return ResponseEntity.ok().body(tickets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().body("");
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Category category){
        categoryService.addCategory(category);
        return ResponseEntity.ok().body("");
    }

    @PutMapping("/{id}")
    public void updateCategory(@PathVariable("id") Long id, Category category){

    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

}
