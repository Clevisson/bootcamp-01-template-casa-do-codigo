package com.bootcamp.casadocodigo.category;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Category> createCategory(@RequestBody @Valid NewCategoryRequest request) {
        Category category = new Category(request.getName());
        manager.persist(category);
        return ResponseEntity.status(201).build();
    }
}
