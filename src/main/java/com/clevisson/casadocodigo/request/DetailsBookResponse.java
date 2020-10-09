package com.clevisson.casadocodigo.request;

import com.clevisson.casadocodigo.model.Book;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetailsBookResponse {
    private DetailsAuthorResponse author;
    private String title;

    public DetailsAuthorResponse getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getNumberPage() {
        return numberPage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    private String isbn;
    private String numberPage;
    private BigDecimal price;
    private String resume;
    private String summary;
    private String publicationDate;

    public DetailsBookResponse(Book book) {
        title = book.getTitle();
        author = new DetailsAuthorResponse(book.getAuthor());
        isbn = book.getIsbn();
        numberPage = book.getIsbn();
        price = book.getPrice();
        resume = book.getResume();
        summary = book.getSummary();
        publicationDate = book.getPublicationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
