package com.clevisson.casadocodigo.controller;

import com.clevisson.casadocodigo.model.Author;
import com.clevisson.casadocodigo.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @GetMapping
    public Iterable<Author> listAuthors() {
        return authorRepository.findAll();
    }
}