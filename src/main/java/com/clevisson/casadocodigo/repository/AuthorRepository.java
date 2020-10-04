package com.clevisson.casadocodigo.repository;

import com.clevisson.casadocodigo.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findByEmail(String email);
}

