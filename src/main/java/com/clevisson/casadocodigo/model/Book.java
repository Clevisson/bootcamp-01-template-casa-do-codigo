package com.clevisson.casadocodigo.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    @Size(max = 500)
    private String resume;
    @NotBlank
    private String summary;
    @NotBlank
    @Min(20)
    private BigDecimal price;
    @NotBlank
    @Min(100)
    private Long numberPages;
    @NotBlank
    private String isbn;
    @NotNull
    @Future
    LocalDate publicationDate;

    @ManyToOne
    @NotNull
    @Valid
    private Category category;

    @ManyToOne
    @NotNull
    @Valid
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(@NotBlank String title,
                @NotBlank @Size(max = 500) String resume,
                @NotBlank String summary,
                @NotBlank @Min(20) BigDecimal price,
                @NotBlank @Min(100) Long numberPages,
                @NotBlank String isbn,
                @NotNull @Future LocalDate publicationDate,
                @NotNull @Valid Category category,
                @NotNull @Valid Author author) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getNumberPages() {
        return numberPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + title + ", resumo=" + resume
                + ", sumario=" + summary + ", preco=" + price
                + ", numeroPaginas=" + numberPages + ", isbn=" + isbn
                + ", dataPublicacao=" + publicationDate + ", autor=" + author
                + ", categoria=" + category + "]";
    }
}
