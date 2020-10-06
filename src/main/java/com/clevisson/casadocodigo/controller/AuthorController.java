package com.clevisson.casadocodigo.controller;

import com.clevisson.casadocodigo.request.newAuthorRequest;
import com.clevisson.casadocodigo.model.Author;
import com.clevisson.casadocodigo.validations.UniqueValueValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class AuthorController {
    @PersistenceContext
    private EntityManager manager;
    @Autowired

    @PostMapping(path = "create/author")
    @Transactional
    public String createAuthor(@RequestBody @Valid newAuthorRequest request) {
        Author author = request.toModel();
        manager.persist(author);
        return author.toString();
    }

}
