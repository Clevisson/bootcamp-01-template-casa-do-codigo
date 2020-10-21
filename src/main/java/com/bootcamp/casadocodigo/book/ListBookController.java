package com.bootcamp.casadocodigo.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping(path = "/book")
public class ListBookController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping(path = "/{id}")
    public ResponseEntity<DetailsBookResponse> listBookById(@PathVariable("id") Long id) {
        Book book = manager.find(Book.class, id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        DetailsBookResponse detailsBookResponse = new DetailsBookResponse(book);
        return ResponseEntity.ok().body(detailsBookResponse);
    }

    @GetMapping
    public Iterable<DetailsBookResponse> listBooks() {
        return manager.createQuery("from Book").getResultList();
    }
}


