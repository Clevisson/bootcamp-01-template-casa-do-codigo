package com.clevisson.casadocodigo.controller;

import com.clevisson.casadocodigo.model.Author;
import com.clevisson.casadocodigo.request.newAuthorRequest;
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
    public String createAuthor(@RequestBody @Valid newAuthorRequest request) {
        Author author = request.toModel();
        manager.persist(author);
        return author.toString();
    }

}
