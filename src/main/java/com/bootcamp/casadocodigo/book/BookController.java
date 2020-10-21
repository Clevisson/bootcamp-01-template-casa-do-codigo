package com.bootcamp.casadocodigo.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Book> createBook(@RequestBody @Valid NewBookRequest request) {
        Book book = request.toModel(manager);
        manager.persist(book);
        return ResponseEntity.status(201).build();
    }
}


