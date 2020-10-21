package com.bootcamp.casadocodigo.book;

import com.bootcamp.casadocodigo.autor.Author;
import com.bootcamp.casadocodigo.category.Category;

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
    @Min(20)
    private BigDecimal price;
    @Min(100)
    private int numberPages;
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
                @Min(20) BigDecimal price,
                @Min(100) int numberPages,
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

    public int getNumberPages() {
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
}
