package com.bootcamp.casadocodigo.command;

import com.bootcamp.casadocodigo.book.Book;
import com.bootcamp.casadocodigo.validations.UniqueId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NewItemCommandRequest {
    @NotNull
    @UniqueId(domainClass = Book.class, fieldName = "id")
    private final Long idBook;
    @Positive
    private final int amount;

    public NewItemCommandRequest(@NotNull Long idBook,
                                 @Positive int amount) {
        super();
        this.idBook = idBook;
        this.amount = amount;
    }

    public Long getIdBook() {
        return idBook;
    }

    public CommandItem toModel(EntityManager manager) {
        @NotNull Book book = manager.find(Book.class, idBook);
        return new CommandItem(amount, book);
    }
}

