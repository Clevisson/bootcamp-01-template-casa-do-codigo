package com.bootcamp.casadocodigo.book;

import com.bootcamp.casadocodigo.autor.DetailsAuthorResponse;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetailsBookResponse {
    private final DetailsAuthorResponse author;
    private final String title;
    private final String isbn;
    private final int numberPage;
    private final BigDecimal price;
    private final String resume;
    private final String summary;
    private final String publicationDate;

    public DetailsBookResponse(Book book) {
        title = book.getTitle();
        author = new DetailsAuthorResponse(book.getAuthor());
        isbn = book.getIsbn();
        numberPage = book.getNumberPages();
        price = book.getPrice();
        resume = book.getResume();
        summary = book.getSummary();
        publicationDate = book.getPublicationDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public DetailsAuthorResponse getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumberPage() {
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
}
