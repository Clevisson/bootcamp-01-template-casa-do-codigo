package com.clevisson.casadocodigo.controller;

import com.clevisson.casadocodigo.model.Book;
import com.clevisson.casadocodigo.request.DetailsBookResponse;
import com.clevisson.casadocodigo.request.NewBookRequest;
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
    public String CreateBook(@RequestBody @Valid NewBookRequest request) {
        Book book = request.toModel(manager);
        manager.persist(book);
        return book.toString();
    }

    @GetMapping(path = {"/id"})
public ResponseEntity<DetailsBookResponse> listBookById(@PathVariable("id") long id){
        Book findBook = manager.find(Book.class, id);
        if (findBook == null) {
            return ResponseEntity.notFound().build();
        }
        DetailsBookResponse detailsBookResponse = new DetailsBookResponse(findBook);
        return ResponseEntity.ok(detailsBookResponse);
    }
}


