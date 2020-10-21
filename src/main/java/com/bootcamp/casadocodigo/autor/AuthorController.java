package com.bootcamp.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {
    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Author> createAuthor(@RequestBody @Valid NewAuthorRequest request) {
        Author author = request.toModel();
        manager.persist(author);
        return ResponseEntity.status(201).build();
    }
}
