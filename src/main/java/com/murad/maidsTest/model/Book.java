package com.murad.maidsTest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")

    private String title;
    @NotBlank(message = "Author is required")
    private String author;
    @NotBlank(message = "publication year is required")
    private String publication_year;
    @NotBlank(message = "ISBN is required")
    private String ISBN;

    @OneToMany(mappedBy = "book")
    private Set<BookBorrow> borrowing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }


    public Set<BookBorrow> getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Set<BookBorrow> borrowing) {
        this.borrowing = borrowing;
    }
}
