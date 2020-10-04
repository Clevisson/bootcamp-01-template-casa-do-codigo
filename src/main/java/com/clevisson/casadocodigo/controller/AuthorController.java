package com.clevisson.casadocodigo.controller;

import com.clevisson.casadocodigo.newAuthorRequest;
import com.clevisson.casadocodigo.ValidateDuplicateEmail;
import com.clevisson.casadocodigo.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    private ValidateDuplicateEmail validateDuplicateEmail;
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(validateDuplicateEmail);
    }

    @PostMapping(path = "create/author")
    @Transactional
    public String createAuthor(@RequestBody @Valid newAuthorRequest request) {
        Author author = request.toModel();
        manager.persist(author);
        return author.toString();
    }

}
