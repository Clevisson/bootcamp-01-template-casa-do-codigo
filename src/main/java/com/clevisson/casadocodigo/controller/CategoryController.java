package com.clevisson.casadocodigo.controller;

import com.clevisson.casadocodigo.model.Category;
import com.clevisson.casadocodigo.request.newCategoryRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public String create(@RequestBody @Valid newCategoryRequest request) {
        Category category = new Category(request.getName());
        manager.persist(category);
        return category.toString();
    }
}
