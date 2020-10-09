package com.clevisson.casadocodigo.repository;

import com.clevisson.casadocodigo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
