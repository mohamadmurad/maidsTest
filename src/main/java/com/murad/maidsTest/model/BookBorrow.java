package com.murad.maidsTest.model;

import jakarta.persistence.*;

@Entity

public class BookBorrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patron_id")
    private Patron patron;


    private boolean isReturned;

    public BookBorrow(Book book, Patron patron) {
        this.book = book;
        this.patron = patron;
        this.isReturned = false;
    }

    public BookBorrow() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public boolean isIsReturned() {
        return isReturned;
    }

    public void setIsReturned(boolean is_returned) {
        this.isReturned = is_returned;
    }
}
